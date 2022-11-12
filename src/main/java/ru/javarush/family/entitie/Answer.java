package ru.javarush.family.entitie;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Answer {

    @JsonProperty("answer")
    private final String answer;
    @JsonProperty("fidelityAnswer")
    private final Boolean fidelityAnswer;

    public Answer(@JsonProperty(value = "answer") String answer,
                  @JsonProperty(value = "fidelityAnswer") Boolean fidelityAnswer) {
        this.answer = answer;
        this.fidelityAnswer = fidelityAnswer;
    }
}
