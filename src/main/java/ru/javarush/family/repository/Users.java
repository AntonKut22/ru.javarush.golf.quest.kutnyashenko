package ru.javarush.family.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.javarush.family.entitie.Role;
import ru.javarush.family.entitie.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@Getter
public class Users {
    private static final Logger log = LogManager.getLogger(Users.class);
    private Map<String, User> userMap;

    public Users(InputStream file) {
        this.userMap = initialisationUsers(file);
        log.info("parsing json {}", this);
    }

    private Map<String, User> initialisationUsers(InputStream file){
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, User> initialisationUsersFromJson;
        try {
            initialisationUsersFromJson = objectMapper.readValue(file, new TypeReference<HashMap<String, User>>() {
            });
        } catch (IOException e) {
            log.error("Error parsing json {}", this);
            throw new RuntimeException(e);
        }

        return initialisationUsersFromJson;
    }

    public User getUser(String name){
        return userMap.get(name);
    }

    public Integer getCountUsers(){
        return userMap.size();
    }

    public void update(String name){
        userMap.put(name, new User(Role.PLAYER, 0));
    }

    public void incrementCountOfGamesPlayer(String name){
        int countOfGamesPlayedUser = userMap.get(name).getCountOfGamesPlayed();
        userMap.get(name).setCountOfGamesPlayed(countOfGamesPlayedUser + 1);
        log.info("increment count of games {}", this);
    }

    public void deleteUser(String name){
        userMap.remove(name);
    }

    @Override
    public String toString() {
        return "Users{" +
                "userMap size=" + userMap.size() +
                '}';
    }
}
