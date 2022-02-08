package br.com.book.service.feign;

import br.com.book.service.feign.response.Cambio;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;

@FeignClient(name = "cambio-service")
public interface CambioFeign {

    @GetMapping("/cambio-service/{amout}/{from}/{to}")
    public Cambio getCambio(final @PathVariable BigDecimal amout,
                            final @PathVariable String from,
                            final @PathVariable String to);

}
