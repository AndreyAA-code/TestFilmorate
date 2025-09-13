package ru.yandex.practicum.filmorate.repository;

import org.springframework.stereotype.Repository;
import ru.yandex.practicum.filmorate.model.Film;

import java.util.Collection;
import java.util.List;

@Repository
public class DbFilmRepository implements FilmRepository {

    @Override
    public Film addFilm(Film film) {
        return null;
    }

    @Override
    public Collection<Film> getAllFilms() {
        return List.of();
    }

    @Override
    public Long getNextId() {
        return 0L;
    }

    @Override
    public Film updateFilm(Film film) {
        return null;
    }

    @Override
    public Film getFilmById(Long id) {
        return null;
    }

    @Override
    public Film deleteFilmById(Long id) {
        return null;
    }

    @Override
    public Film likeFilmById(Long id, Long userId) {
        return null;
    }

    @Override
    public Film deleteLikeUser(Long id, Long userId) {
        return null;
    }
}
