package com.quizroulette.quizlogeventservice;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@AllArgsConstructor
public class QuizLogServiceAdapter {

  private final QuizLogEventJPARepository quizLogEventJPARepository;

  public Flux<QuizLogEvent> generateSummary(String quizId) {

    Map<String, Optional<QuizLogEvent>> block = quizLogEventJPARepository.findAll()
        .collect(Collectors.groupingBy(QuizLogEvent::getQuizUserId,
            Collectors.reducing((quizLogEvent, quizLogEvent2) -> {
              QuizLogEvent quizLogEvent1 = new QuizLogEvent();
              quizLogEvent1.setQuizId(quizId);
              quizLogEvent1.setQuizUserId(quizLogEvent.getQuizUserId());
              quizLogEvent1.setScore(quizLogEvent.getScore() + quizLogEvent2.getScore());
              quizLogEvent1
                  .setTimeTaken(quizLogEvent.getTimeTaken() + quizLogEvent2.getTimeTaken());
              return quizLogEvent1;
            }))).share().block();

    if (block != null) {
      List<QuizLogEvent> collect = block.values().stream()
          .filter(Optional::isPresent)
          .map(Optional::get)
          .collect(Collectors.toList());
      return Flux.fromArray(collect.toArray(new QuizLogEvent[]{}));
    }

    return null;
  }

  public Mono<Long> getCount(String quizId) {
    return quizLogEventJPARepository.findAll()
        .filter(quizLogEvent -> quizLogEvent.getQuizId().equals(quizId)).count();
  }
}

