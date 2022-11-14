package ru.javarush.family.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import ru.javarush.family.entitie.Role;
import ru.javarush.family.entitie.User;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Getter
public class Users {

    private Map<String, User> userMap;

    public Users(File file) {
        this.userMap = initialisationUsers(file);
    }

    private Map<String, User> initialisationUsers(File file){
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, User> initialisationUsersFromJson;
        try {
            initialisationUsersFromJson = objectMapper.readValue(file, new TypeReference<HashMap<String, User>>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return initialisationUsersFromJson;
    }

    public User getUser(String name){
        return userMap.get(name);
    }

    public void update(String name){
        userMap.put(name, new User(Role.PLAYER, 0));
    }

    public void incrementCountOfGamesPlayer(String name){
        int countOfGamesPlayedUser = userMap.get(name).getCountOfGamesPlayed();
        userMap.get(name).setCountOfGamesPlayed(countOfGamesPlayedUser + 1);
    }

    public void deleteUser(String name){
        userMap.remove(name);
    }
}
