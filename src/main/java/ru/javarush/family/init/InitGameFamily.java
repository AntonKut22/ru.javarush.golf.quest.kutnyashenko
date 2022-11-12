package ru.javarush.family.init;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.parser.ParseException;
import ru.javarush.family.entitie.Question;
import ru.javarush.family.entitie.User;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//TODO сделать синглтоном
public class InitGameFamily {

    private static volatile InitGameFamily instance;

    private final Map<String, User> userMap;
    private final Map<Long, Question> questionMap;

    public static InitGameFamily getInstance() throws IOException, ParseException {
        InitGameFamily localInstance = instance;
        if (localInstance == null) {
            synchronized (InitGameFamily.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new InitGameFamily();
                }
            }
        }
        return localInstance;
    }

    private InitGameFamily() throws IOException, ParseException {
        ObjectMapper objectMapper = new ObjectMapper();
        File fileQuestion = new File("D:\\Обучение\\JRU\\ru.familyQuest\\family\\src\\main\\resources\\questions.json");
        File fileUser = new File("D:\\Обучение\\JRU\\ru.familyQuest\\family\\src\\main\\resources\\users.json");

        questionMap = objectMapper.readValue(fileQuestion, new TypeReference<HashMap<Long, Question>>() {
        });
        userMap = objectMapper.readValue(fileUser, new TypeReference<HashMap<String, User>>() {
        });

    }

    public Map<Long, Question> getQuestionMap() {
        return questionMap;
    }

    public Map<String, User> getUsers() {
        return userMap;
    }


    public static void main(String[] args) {

    }
}
