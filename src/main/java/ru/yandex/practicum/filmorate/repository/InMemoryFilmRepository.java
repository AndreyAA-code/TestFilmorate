package ru.yandex.practicum.filmorate.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import ru.yandex.practicum.filmorate.exceptions.MethodArgumentNotValidException;
import ru.yandex.practicum.filmorate.exceptions.NotFoundException;
import ru.yandex.practicum.filmorate.model.Film;

import java.util.Collection;
import java.util.HashMap;

import static java.util.Arrays.stream;

@Primary
@Repository
@RequiredArgsConstructor

public class InMemoryFilmRepository implements FilmRepository {

    private final HashMap<Long, Film> films = new HashMap<>();

    @Override
    public Collection<Film> getAllFilms() {
        return films.values();
    }

    @Override
    public Film addFilm(Film film) {
        film.setId(getNextId());
        films.put(film.getId(), film);
        return film;
    }

    @Override
    public Long getNextId() {
        Long maxID = films.keySet()
                .stream()
                .mapToLong(id -> id)
                .max()
                .orElse(0L);
                return ++maxID;
    }


    @Override
    public Film updateFilm(Film newFilm) {

        Film oldFilm = films.get(newFilm.getId());
        oldFilm.setName(newFilm.getName());
        oldFilm.setDescription(newFilm.getDescription());
        oldFilm.setDuration(newFilm.getDuration());
        oldFilm.setReleaseDate(newFilm.getReleaseDate());
        return oldFilm;
    }

    @Override
    public Film getFilmById(Long id) {
        if (!films.containsKey(id)) {
            throw new NotFoundException("Film with id " + id + " not found");
        }
        try
        {return films.get(id);
    } catch (MethodArgumentNotValidException e) {
            e
        }
}

