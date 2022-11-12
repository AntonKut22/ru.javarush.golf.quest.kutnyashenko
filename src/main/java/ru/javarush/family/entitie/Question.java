package ru.javarush.family.entitie;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;

@Getter
@ToString
@JsonTypeName
public class Question {

    @JsonProperty("question")
    private String question;
    @JsonProperty("answers")
    private ArrayList<Answer> answers;
    @JsonProperty("whyFailure")
    private String whyFailure;
    @JsonProperty("pathToImage")
    private String pathToImage;

    public Question(){

    }

    public Question(@JsonProperty(value = "question") String question,
                    @JsonProperty(value = "answers") ArrayList<Answer> answers,
                    @JsonProperty(value = "whyFailure") String whyFailure,
                    @JsonProperty(value = "pathToImage") String pathToImage) {
        this.question = question;
        this.answers = answers;
        this.whyFailure = whyFailure;
        this.pathToImage = pathToImage;
    }
}
