package ru.yandex.practicum.filmorate.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.filmorate.model.Genre;
import ru.yandex.practicum.filmorate.model.Mpa;
import ru.yandex.practicum.filmorate.model.User;
import ru.yandex.practicum.filmorate.service.FilmService;
import ru.yandex.practicum.filmorate.model.Film;
import ru.yandex.practicum.filmorate.service.UserService;

import java.util.Collection;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/films")
public class FilmController {

    public final FilmService filmService;
    private final UserService userService;

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

    @DeleteMapping("/{id}")
    public Film deleteFilmById(@PathVariable Long id) {
        return filmService.deleteFilmById(id);
    }

    @PutMapping("/{id}/like/{userId}")
    public Film likeFilmById(@PathVariable Long id, @PathVariable Long userId) {
        return filmService.likeFilmById(id, userId);
    }

    @DeleteMapping("/{id}/like/{userId}")
    public Film deleteLikeUser(@PathVariable Long id, @PathVariable Long userId) {
        return filmService.deleteLikeUser(id, userId);
    }

    @GetMapping("/popular")
    public Collection<Film> getPopularFilms(@RequestParam(defaultValue = "10") Long count) {
        return filmService.getPopularFilms(count);
    }

    @GetMapping("/genres")
    public Collection<Genre> getGenres() {
        return filmService.getGenres();
    }

    @GetMapping("/genres/{id}")
    public Genre getGenreById(@Valid @PathVariable Long id) {
        return filmService.getGenresById(id);
    }

    @GetMapping("/mpa")
    public Collection<Mpa> getMpas() {
        return filmService.getMpas();
    }

    @GetMapping("/genres/{id}")
    public Mpa getMpaById(@Valid @PathVariable Long id) {
        return filmService.getMpaById(id);
    }
}
