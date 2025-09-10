package ru.yandex.practicum.filmorate.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.yandex.practicum.filmorate.model.Film;

import java.util.Collection;
import java.util.HashMap;

@Repository
@RequiredArgsConstructor

public class InMemoryUserRepository {

    private final HashMap<Long, Film> films  = new HashMap<>();

    public Collection<Film> getAllfilms(){
       return films.values();
    }

    public Film addFilm(Film film){

        return film;
    }
}
