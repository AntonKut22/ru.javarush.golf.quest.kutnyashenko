package ru.javarush.family.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.javarush.family.entity.Role;
import ru.javarush.family.entity.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@Getter
public class Users {

    ObjectMapper objectMapper = new ObjectMapper();
    private static final Logger log = LogManager.getLogger(Users.class);
    private Map<String, User> nameUserToCharacteristic;

    public Users(InputStream file) {
        this.nameUserToCharacteristic = initialisationUsers(file);
        log.info("parsing json users");
    }

    private Map<String, User> initialisationUsers(InputStream file){
        Map<String, User> initialisationUsersFromJson;
        try {
            initialisationUsersFromJson = objectMapper.readValue(file, new TypeReference<HashMap<String, User>>() {
            });
        } catch (IOException e) {
            log.error("Error parsing json users");
            throw new RuntimeException(e);
        }

        return initialisationUsersFromJson;
    }

    public User getUser(String name){
        return nameUserToCharacteristic.get(name);
    }

    public Integer getCountUsers(){
        return nameUserToCharacteristic.size();
    }

    public void update(String name){
        nameUserToCharacteristic.put(name, new User(Role.PLAYER, 0));
    }

    public void incrementCountOfGamesPlayer(String name){
        int countOfGamesPlayedUser = nameUserToCharacteristic.get(name).getCountOfGamesPlayed();
        nameUserToCharacteristic.get(name).setCountOfGamesPlayed(countOfGamesPlayedUser + 1);
        log.info("increment count of games");
    }
}
