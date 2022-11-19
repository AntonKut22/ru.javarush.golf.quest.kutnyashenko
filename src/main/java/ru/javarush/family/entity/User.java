package ru.javarush.family.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {

    @JsonProperty("role")
    private Role role;
    @JsonProperty("countOfGamesPlayed")
    private int countOfGamesPlayed;

    public User(@JsonProperty(value = "role") Role role,
                @JsonProperty(value = "countOfGamesPlayed") int countOfGamesPlayed) {
        this.role = role;
        this.countOfGamesPlayed = countOfGamesPlayed;
    }

    //TODO Добавить количество побед

}
