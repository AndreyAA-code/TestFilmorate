package ru.yandex.practicum.filmorate.repository;

import org.springframework.context.annotation.Primary;
import ru.yandex.practicum.filmorate.model.Film;

import java.util.Collection;

@Primary
public interface FilmRepository {

    public Film addFilm(Film film);

    public Collection<Film> getAllFilms();

    public Long getNextId();

    public Film updateFilm(Film film);
}
