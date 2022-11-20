package ru.javarush.family.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.javarush.family.entity.User;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
class UsersTest {

    @Mock
    private Users users;

    @Mock
    private Map<String, User> nameUserToCharacteristic;



    @ParameterizedTest
    @ValueSource(strings = {"Ivan", "Oleg", "Sergey", "Anatoly"})
    void getUser(String name) {
        assertEquals(nameUserToCharacteristic.get(name), users.getUser(name));
    }

    @Test
    void getCountUsers() {
        assertEquals(nameUserToCharacteristic.size(), users.getCountUsers());
    }
}