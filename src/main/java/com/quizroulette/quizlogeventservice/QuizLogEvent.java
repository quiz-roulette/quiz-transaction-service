package com.quizroulette.quizlogeventservice;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuizLogEvent {

  @Id
  private String id;
  @JsonProperty("QuizId")
  private String quizId;
  @JsonProperty("QuizUserId")
  private String quizUserId;
  @JsonProperty("QuestionId")
  private Integer questionId;
  @JsonProperty("QuestionText")
  private String questionText;
  @JsonProperty("ChoiceId")
  private String choiceId;
  @JsonProperty("ChoiceText")
  private String choiceText;
  @JsonProperty("Score")
  private Integer score;
  @JsonProperty("TimeTaken")
  private Integer timeTaken;

}
