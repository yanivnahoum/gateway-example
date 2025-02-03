package com.att.training.gateway.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@SpringBootTest
@AutoConfigureWebTestClient
class GreetControllerTest {
    @Autowired
    private WebTestClient webClient;

    @Test
    void givenRequestWithNameParam_whenGet_thenOkWithGreeting() {
        webClient.get()
                .uri("/api/hello?name=John")
                .accept(APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("Hello, John!");
    }

    @Test
    void givenRequestWithoutNameParam_whenGet_thenBadRequestWithOperationType() {
        webClient.get()
                .uri("/api/hello")
                .accept(APPLICATION_JSON)
                .exchange()
                .expectStatus().isBadRequest()
                .expectBody().jsonPath("$.operationType").isEqualTo("HELLO");
    }
}
