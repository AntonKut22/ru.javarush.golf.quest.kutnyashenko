package ru.javarush.family.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import ru.javarush.family.entitie.Question;
import ru.javarush.family.entitie.User;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Getter
public class Questions {

    private Map<Long, Question> questionsMap;

    public Questions(File file) {
        this.questionsMap = initialisationUsers(file);
    }

    private Map<Long, Question> initialisationUsers(File file){
        ObjectMapper objectMapper = new ObjectMapper();
        Map<Long, Question> initialisationQuestionsFromJson;
        try {
            initialisationQuestionsFromJson = objectMapper.readValue(file, new TypeReference<HashMap<Long, Question>>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return initialisationQuestionsFromJson;
    }

    public Question getQuestion(Long id){
        return questionsMap.get(id);
    }

}
