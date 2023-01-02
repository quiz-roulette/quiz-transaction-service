package com.quizroulette.quizlogeventservice;

import static org.springframework.web.reactive.function.BodyExtractors.toMono;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

@Slf4j
@Configuration
public class QuizLogRouteController {

  @Bean
  RouterFunction<ServerResponse> getAllLogs(QuizLogEventJPARepository quizLogEventJPARepository) {
    return route()
        .GET("/quizlogs",
            serverRequest -> ok()
                .body(quizLogEventJPARepository.findAll(), QuizLogEvent.class))
        .build();
  }

  @Bean
  RouterFunction<ServerResponse> addQuizLog(QuizLogEventJPARepository quizLogEventJPARepository) {
    return route(POST("/quizlogs"),
        req -> req.body(toMono(QuizLogEvent.class))
            .doOnNext(quizlogEvent -> log.info("{}", quizlogEvent))
            .doOnNext(quizLogEvent -> quizLogEventJPARepository.save(quizLogEvent).subscribe())
            .then(ok().build()));
  }

  @Bean
  RouterFunction<ServerResponse> getQuizLogSummarised(QuizLogServiceAdapter quizLogServiceAdapter) {
    return route()
        .GET("/quizlogs/{quizId}/summary",
            serverRequest -> ok()
                .body(quizLogServiceAdapter.generateSummary(serverRequest.pathVariable("quizId")),
                    QuizLogEvent.class))
        .build();
  }

  @Bean
  RouterFunction<ServerResponse> getCountByQuizId(QuizLogServiceAdapter quizLogServiceAdapter) {
    return route()
        .GET("/quizlogs/{quizId}/count",
            serverRequest -> ok()
                .body(quizLogServiceAdapter.getCount(serverRequest.pathVariable("quizId")),
                    QuizLogEvent.class))
        .build();
  }

  @Bean
  RouterFunction<ServerResponse> deleteQuizLog(
      QuizLogEventJPARepository quizLogEventJPARepository) {
    return route()
        .DELETE("/quizlogs",
            serverRequest -> ok()
                .body(quizLogEventJPARepository.deleteAll().log(), QuizLogEvent.class))
        .build();
  }
}
