package ru.yandex.practicum.filmorate.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import ru.yandex.practicum.filmorate.exceptions.NotFoundException;
import ru.yandex.practicum.filmorate.model.Film;
import ru.yandex.practicum.filmorate.model.Mpa;
import ru.yandex.practicum.filmorate.service.UserService;

import java.util.*;
import java.util.stream.Collectors;

@Primary
@Repository
@RequiredArgsConstructor

public class InMemoryFilmRepository implements FilmRepository {

    private final HashMap<Long, Film> films = new HashMap<>();
    private final UserService userService;
    private final Map<Long, Mpa> mpas = Map.of(
            1L, new Mpa(1L, "G"),
            2L, new Mpa(2L, "PG"),
            3L, new Mpa(3L, "PG-13"),
            4L, new Mpa(4L, "R"),
            5L, new Mpa(5L, "NC-17")
    );

    @Override
    public Collection<Film> getAllFilms() {
        return films.values();
    }

    @Override
    public Film addFilm(Film film) {
        film.setId(getNextId());
        film.setMpa(mpas.get(film.getMpa().getId()));
        films.put(film.getId(), film);
        return film;
    }

    @Override
    public Film updateFilm(Film newFilm) {
        checkIfFilmExists(newFilm.getId());
        Film oldFilm = films.get(newFilm.getId());
        oldFilm.setName(newFilm.getName());
        oldFilm.setDescription(newFilm.getDescription());
        oldFilm.setDuration(newFilm.getDuration());
        oldFilm.setReleaseDate(newFilm.getReleaseDate());
        return oldFilm;
    }

    @Override
    public Film getFilmById(Long id) {
        checkIfFilmExists(id);
        return films.get(id);
    }

    @Override
    public Film deleteFilmById(Long id) {
        checkIfFilmExists(id);
        return films.remove(id);
    }

    @Override
    public Film likeFilmById(Long id, Long userId) {
        checkIfFilmExists(id);
        films.get(id).getLikes().add(userService.getUserById(userId));
        return films.get(id);
    }

    @Override
    public Film deleteLikeUser(Long id, Long userId) {
        checkIfFilmExists(id);
        films.get(id).getLikes().remove(userService.getUserById(userId));
        return films.get(id);
    }

    public void checkIfFilmExists(Long id) {
        if (!films.containsKey(id)) {
            throw new NotFoundException("Film with id " + id + " not found");
        }
    }

    @Override
    public Collection<Film> getPopularFilms(Long count) {
        return films.values()
                .stream()
                .sorted(Comparator.comparing((Film film) -> film.getLikes().size()).reversed())
                .limit(count)
                .collect(Collectors.toList());
    }

    public Long getNextId() {
        long maxID = films.keySet()
                .stream()
                .mapToLong(id -> id)
                .max()
                .orElse(0L);
        return ++maxID;
    }

}

