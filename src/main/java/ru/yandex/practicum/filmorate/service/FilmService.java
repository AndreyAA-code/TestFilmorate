package ru.yandex.practicum.filmorate.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.filmorate.model.Film;
import ru.yandex.practicum.filmorate.repository.FilmRepository;

import java.util.Collection;

//переделать на интерфейс
//добавить класс в памяти
//добавить локальное сохранение и загрузку в/из файл

@Service
@AllArgsConstructor
public class FilmService {

    @Qualifier("inMemoryFilmRepository")
    public final FilmRepository filmRepository;

    public Collection<Film> getAllFilms() {
        return filmRepository.getAllFilms();
    }

    public Film addFilm(Film film) {
        return filmRepository.addFilm(film);
    }

    public Film updateFilm(Film film) {
        return filmRepository.updateFilm(film);
    }

    public Film getFilmById(Long id) {
        return filmRepository.getFilmById(id);
    }

    public Film deleteFilmById(Long id) {
        return filmRepository.deleteFilmById(id);
    }

}
