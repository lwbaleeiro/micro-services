package br.com.book.service.controller;

import io.github.resilience4j.retry.annotation.Retry;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Tag(name = "Foo Bar API")
@RestController
@RequestMapping("/book-service")
public class FooBarController {

    private final Logger logger = LoggerFactory.getLogger(FooBarController.class);

    @Operation(summary = "Foo Bar")
    @GetMapping("/foo-bar")
    @Retry(name = "default", fallbackMethod = "fallbackMethod") // tenta 3x
    //@CircuitBreaker(name = "default", fallbackMethod = "fallbackMethod")
    //@RateLimiter(name = "default")
    //@Bulkhead(name = "default")
    public String fooBar() {

        logger.info("Request foo bar received");

        return new RestTemplate().getForEntity("http://localhost:8000/foo-bar", String.class).getBody();
    }

    private String fallbackMethod(Exception exception) {
        return "fallbackMethod";
    }

}
