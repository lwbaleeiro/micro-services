package br.com.book.service.controller;

import br.com.book.service.feign.CambioFeign;
import br.com.book.service.feign.response.Cambio;
import br.com.book.service.model.Book;
import br.com.book.service.repository.BookRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;

@Tag(name = "Book endpoint")
@RestController
@RequestMapping("/book-service")
@AllArgsConstructor
@Slf4j
public class BookController {

    private final Environment environment;
    private final BookRepository bookRepository;
    private final CambioFeign cambioFeign;

    @Operation(summary = "Find a specific book by your ID")
    @GetMapping("/{id}/{currency}")
    public Book findBook(final @PathVariable Long id,
                         final @PathVariable String currency) {

        var property = environment.getProperty("local.server.port");
        log.info("server port: {}", property);

        log.info("find book by id {}", id);
        var book = bookRepository.getById(id);
        if (book == null) throw new EntityNotFoundException("book not found by this id: " + id);

        var cambio = cambioFeign.getCambio(book.getPrice(), "USD", currency);

        book.setEnvironment("Book port: " + property + " Cambio port: " + cambio.getEnvironment());
        book.setCurrency(currency);
        book.setPrice(cambio.getConvertedValue());

        log.info("finished the process");
        return book;
    }

}
