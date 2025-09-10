package ru.yandex.practicum.filmorate.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.yandex.practicum.filmorate.FilmService;
import ru.yandex.practicum.filmorate.model.Film;

import java.util.List;

@RestController
@RequestMapping("/films")
public class FilmController {

    static final FilmService filmservice = new FilmService();

    @GetMapping
    public List<Film> getAllFilms() {
        return filmservice.getAllFilms();
    }



}
