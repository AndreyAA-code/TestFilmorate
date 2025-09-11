package ru.yandex.practicum.filmorate.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.filmorate.FilmService;
import ru.yandex.practicum.filmorate.exceptions.ParameterNotValidException;
import ru.yandex.practicum.filmorate.model.Film;

import java.util.Collection;

@AllArgsConstructor
@RestController
@RequestMapping("/films")
public class FilmController {

    public final FilmService filmService;

    @GetMapping
    public Collection<Film> getAllFilms() {
        return filmService.getAllFilms();
    }

    @GetMapping("{id}")
    public Film getFilmById(@Valid @PathVariable Long id) {
            return filmService.getFilmById(id);
    }


    @PostMapping
    public Film addFilm(@Valid @RequestBody Film film) {
        return filmService.addFilm(film);
    }

    @PutMapping
    public Film updatFilm(@Valid @RequestBody Film film) {
        return filmService.updateFilm(film);
    }


}
