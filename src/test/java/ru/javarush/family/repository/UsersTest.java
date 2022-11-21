package ru.javarush.family.repository;

import org.junit.jupiter.api.Test;
import ru.javarush.family.controller.DispatcherServlet;

import static org.junit.jupiter.api.Assertions.*;


class UsersTest {

    private final Users users = new Users(DispatcherServlet.class.
            getClassLoader().getResourceAsStream("users.json"));

    @Test
    void getUserExistingInJson() {
        String existingName = "Petya";
        assertNotNull(users.getUser(existingName));
    }

    @Test
    void getUserNonExistingInJson() {
        String nonexistentName = "Ivan";
        assertNull(users.getUser(nonexistentName));
    }

    @Test
    void getCountUsers() {
        assertEquals(2, users.getCountUsers());
    }

    @Test
    void updateMapNewUser() {
        String name = "Igor";
        assertNull(users.getUser(name));
        users.update(name);
        assertNotNull(users.getUser(name));
    }

    @Test
    void incrementCountOfGamesPlayer(){
        String name = "Petya";
        assertEquals(10, users.getUser(name).getCountOfGamesPlayed());
        users.incrementCountOfGamesPlayer(name);
        assertEquals(11, users.getUser(name).getCountOfGamesPlayed());
    }
}