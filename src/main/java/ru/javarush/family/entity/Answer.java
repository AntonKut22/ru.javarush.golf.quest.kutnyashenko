package ru.javarush.family.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Answer {

    @JsonProperty("answer")
    private final String textAnswer;
    @JsonProperty("fidelityAnswer")
    private final Boolean fidelityAnswer;

    public Answer(@JsonProperty(value = "answer") String textAnswer,
                  @JsonProperty(value = "fidelityAnswer") Boolean fidelityAnswer) {
        this.textAnswer = textAnswer;
        this.fidelityAnswer = fidelityAnswer;
    }
}
