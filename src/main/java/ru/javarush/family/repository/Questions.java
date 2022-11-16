package ru.javarush.family.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.ToString;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.javarush.family.entitie.Question;
import ru.javarush.family.entitie.User;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Getter
public class Questions {
    private static final Logger log = LogManager.getLogger(Questions.class);
    private Map<Long, Question> questionsMap;

    public Questions(File file) {
        this.questionsMap = initialisationUsers(file);
        log.info("parsing json {}", this);
    }

    private Map<Long, Question> initialisationUsers(File file) {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<Long, Question> initialisationQuestionsFromJson;
        try {
            initialisationQuestionsFromJson = objectMapper.readValue(file, new TypeReference<HashMap<Long, Question>>() {
            });
        } catch (IOException e) {
            log.error("Error parsing json {}", this);
            throw new RuntimeException(e);
        }
        return initialisationQuestionsFromJson;
    }

    public Question getQuestion(Long id) {
        return questionsMap.get(id);
    }

    public Integer getCountQuestion(){
        return questionsMap.size();
    }

    @Override
    public String toString() {
        return "Questions{" +
                "questionsMap size=" + questionsMap.size() +
                '}';
    }
}
