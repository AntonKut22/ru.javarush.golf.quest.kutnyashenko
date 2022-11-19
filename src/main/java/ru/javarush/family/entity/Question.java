package ru.javarush.family.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;

@Getter
@ToString
@JsonTypeName
public class Question {

    @JsonProperty("question")
    private String textQuestion;
    @JsonProperty("answers")
    private ArrayList<Answer> answers;
    @JsonProperty("whyFailure")
    private String whyFailure;
    @JsonProperty("pathToImage")
    private String pathToImage;

    public Question(){

    }

    public Question(@JsonProperty(value = "question") String textQuestion,
                    @JsonProperty(value = "answers") ArrayList<Answer> answers,
                    @JsonProperty(value = "whyFailure") String whyFailure,
                    @JsonProperty(value = "pathToImage") String pathToImage) {
        this.textQuestion = textQuestion;
        this.answers = answers;
        this.whyFailure = whyFailure;
        this.pathToImage = pathToImage;
    }
}
