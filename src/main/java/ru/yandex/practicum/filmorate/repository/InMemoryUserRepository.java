package ru.yandex.practicum.filmorate.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.filmorate.model.Film;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor

public class InMemoryUserRepository {

    private final HashMap<Long, Film> films  = new HashMap<>();

    public Collection<Film> getAllfilms(){
       return films.values();
    }

    public <Film> addFilm(Film film){

        return film;
    }
}
