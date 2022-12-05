package ru.javarush.family.repository;

import org.junit.jupiter.api.Test;
import ru.javarush.family.controller.DispatcherServlet;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


class QuestionsTest {

    private final Questions questions = new Questions(DispatcherServlet.class
            .getClassLoader().getResourceAsStream("questions.json"));


    @Test
    void getQuestionExistingInJson() {
        Long id = 1L;
        assertNotNull(questions.getQuestion(id));
    }

    @Test
    void getQuestionNonExistingInJson() {
        Long id = 100L;
        assertNull(questions.getQuestion(id));
    }

    @Test
    void getQuestionIncorrectJson() {
        Throwable thrown = assertThrows(RuntimeException.class, () -> new Questions(DispatcherServlet.class
                .getClassLoader().getResourceAsStream("incorrectQuestions.json")));
    }
}
