package com.quizroulette.quizlogeventservice;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

interface QuizLogEventJPARepository extends ReactiveCrudRepository<QuizLogEvent, String> {

  Flux<QuizLogEvent> getQuizLogEventByQuizId(String quizId);

}
