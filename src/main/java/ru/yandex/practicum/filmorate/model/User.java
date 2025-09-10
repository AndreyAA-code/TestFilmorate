package ru.yandex.practicum.filmorate.model;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    long id;
    String email;
    String login;
    String name;
    Date birthDate;
}
