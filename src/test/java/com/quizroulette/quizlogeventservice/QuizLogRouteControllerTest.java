package com.quizroulette.quizlogeventservice;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


import io.r2dbc.spi.ConnectionFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@Disabled
@WebFluxTest(controllers = {QuizLogRouteController.class})
class QuizLogRouteControllerTest {

  @Autowired
  private WebTestClient client;

  @MockBean
  private QuizLogEventJPARepository quizLogEventJPARepository;

  @MockBean
  private QuizLogServiceAdapter quizLogServiceAdapter;

  private QuizLogEvent q1, q2;

  @BeforeEach
  public void setup() {
    q1 = new QuizLogEvent("Id", "quizId", "usera", 1,"text", "2","text1", 250, 10);
    q2 = new QuizLogEvent("Id", "quizId", "usera", 2,"2","2", "choice", 250, 10);
    Flux<QuizLogEvent> just = Flux.just(q1, q2);

    when(quizLogEventJPARepository.findAll()).thenReturn(just);
    when(quizLogEventJPARepository.save(any())).thenReturn(Mono.just(q1));
    when(quizLogServiceAdapter.generateSummary(ArgumentMatchers.eq("mathquiz"))).thenReturn(just);
  }

  @Test
  public void getAllQuizLogs() {
    StepVerifier.create(client.get()
        .uri("/quizlogs")
        .exchange()
        .expectStatus().isOk()
        .expectHeader().contentType(MediaType.APPLICATION_JSON)
        .returnResult(QuizLogEvent.class)
        .getResponseBody())
        .expectNext(q1)
        .expectNext(q2)
        .verifyComplete();
  }

  @Test
  public void getSummaryQuizLogs() {
    StepVerifier.create(client.get()
        .uri("/quizlogs/mathquiz/summary")
        .exchange()
        .expectStatus().isOk()
        .expectHeader().contentType(MediaType.APPLICATION_JSON)
        .returnResult(QuizLogEvent.class)
        .getResponseBody())
        .expectNext(q1)
        .expectNext(q2)
        .verifyComplete();
  }

  @Test
  public void addQuizLog() {
    StepVerifier.create(client.post()
        .uri("/quizlogs")
        .body(Mono.just(q1), QuizLogEvent.class)
        .exchange()
        .expectStatus().isOk()
        .returnResult(Void.class)
        .getResponseBody())
        .verifyComplete();
  }

}