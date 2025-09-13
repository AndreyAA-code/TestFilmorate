package ru.yandex.practicum.filmorate.repository;

import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.PathVariable;
import ru.yandex.practicum.filmorate.model.Film;

import java.util.Collection;

@Primary
public interface FilmRepository {

    public Film addFilm(Film film);

    public Collection<Film> getAllFilms();

    public Long getNextId();

    public Film updateFilm(Film film);

    public Film getFilmById(Long id);

    public Film deleteFilmById(Long id);

    public Film likeFilmById(Long id, Long userId);

    public Film deleteLikeUser(Long id, Long userId);

}
