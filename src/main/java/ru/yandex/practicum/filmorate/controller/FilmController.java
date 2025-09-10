package ru.yandex.practicum.filmorate.controller;

import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.filmorate.FilmService;
import ru.yandex.practicum.filmorate.model.Film;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/films")
public class FilmController {

    static final FilmService filmService = new FilmService();

    @GetMapping
    public Collection<Film> getAllFilms() {
        return filmService.getAllFilms();
    }

@PostMapping
    public <Film> addFilm(@RequestBody Film film) {
        filmService.addFilm(film);
}


}
