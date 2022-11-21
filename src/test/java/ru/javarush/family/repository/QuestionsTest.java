package ru.javarush.family.repository;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.javarush.family.entity.Question;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
class QuestionsTest {

    @Mock
    private Questions questions;

    @Mock
    private Map<Long, Question> idToQuestion;

    @ParameterizedTest
    @ValueSource(longs = {0, 5, 1000000, -50000})
    void getQuestionFromMapByKey(Long id) {
        assertEquals(questions.getQuestion(id), idToQuestion.get(id));
    }
}