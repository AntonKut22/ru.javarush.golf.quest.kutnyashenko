package ru.javarush.family.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.javarush.family.entity.Question;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class Questions {

    ObjectMapper objectMapper = new ObjectMapper();
    private static final Logger log = LogManager.getLogger(Questions.class);
    @Getter
    private Map<Long, Question> idToQuestion;

    public Questions(InputStream file) {
        this.idToQuestion = initialisationUsers(file);
        log.info("parsing json questions");
    }

    private Map<Long, Question> initialisationUsers(InputStream file) {

        Map<Long, Question> initialisationQuestionsFromJson;
        try {
            initialisationQuestionsFromJson = objectMapper.readValue(file, new TypeReference<HashMap<Long, Question>>() {
            });
        } catch (IOException e) {
            log.error("Error parsing json questions");
            throw new RuntimeException(e);
        }
        return initialisationQuestionsFromJson;
    }

    public Question getQuestion(Long id) {
        return idToQuestion.get(id);
    }
}
