package com.quizroulette.quizlogeventservice;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;

@Slf4j
@ExtendWith(MockitoExtension.class)
class QuizLogServiceAdapterTest {

  @InjectMocks
  private QuizLogServiceAdapter quizLogServiceAdapter;

  @Mock
  private QuizLogEventJPARepository quizLogEventJPARepository;

  @Test
  public void testShouldSummariseQuizLog() {
    Flux<QuizLogEvent> just = Flux.just(
        new QuizLogEvent("Id", "quizId", "usera", 1, "1", "2", "2c", 250, 10),
        new QuizLogEvent("Id", "quizId", "usera", 2, "2", "2", "2", 250, 10),
        new QuizLogEvent("Id", "quizId", "userb", 1, "1", "2", "2", 250, 15),
        new QuizLogEvent("Id", "quizId", "userb", 2, "2", "2", "2", 100, 19),
        new QuizLogEvent("Id", "quizId", "userc", 3, "3", "2", "2", 350, 19),
        new QuizLogEvent("Id", "anotherQuiz", "usera", 1, "1", "2", "2", 250, 10),
        new QuizLogEvent("Id", "randomQuiz", "usera", 2, "2", "2", "2", 250, 10)
    );

    Mockito.when(quizLogEventJPARepository.findAll()).thenReturn(just);

    Flux<QuizLogEvent> quizLogEventFlux = quizLogServiceAdapter.generateSummary("quizId");
    List<QuizLogEvent> quizLogEvents = quizLogEventFlux.collectList().block();
    Assertions.assertNotNull(quizLogEvents);
    Assertions.assertEquals(3, quizLogEvents.size());
  }
}