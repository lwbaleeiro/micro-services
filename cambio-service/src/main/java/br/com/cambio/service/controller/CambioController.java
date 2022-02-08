package br.com.cambio.service.controller;

import br.com.cambio.service.model.Cambio;
import br.com.cambio.service.repository.CambioRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.ObjectNotFoundException;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Tag(name = "Cambio Service API")
@RestController
@RequestMapping("/cambio-service")
@Slf4j
@AllArgsConstructor
public class CambioController {

    private final Environment environment;
    private final CambioRepository cambioRepository;

    @Operation(summary = "Get cambio from currency")
    @GetMapping("/{amount}/{from}/{to}")
    public Cambio getCambio(final @PathVariable BigDecimal amount,
                            final @PathVariable String from,
                            final @PathVariable String to) {

        log.info(" getCambio amount {}, from {}, to {}", amount, from, to);

        var cambio = cambioRepository.findByFromAndTo(from, to);
        if (cambio == null) throw new ObjectNotFoundException("Cambio", "Currency Unsupported");

        var port = environment.getProperty("local.server.port");

        BigDecimal conversionFactor = cambio.getConversionFactor();
        BigDecimal convertedValue = conversionFactor.multiply(amount);

        cambio.setEnvironment(port);
        cambio.setConvertedValue(convertedValue.setScale(2, RoundingMode.CEILING));

        return cambio;
    }

}
