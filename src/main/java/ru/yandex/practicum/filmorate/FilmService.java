package ru.yandex.practicum.filmorate;

import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.aot.generate.InMemoryGeneratedFiles;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.filmorate.model.Film;
import ru.yandex.practicum.filmorate.repository.InMemoryUserRepository;

import java.util.Collection;
import java.util.List;

//переделать на интерфейс
//добавить класс в памяти

@Service
@AllArgsConstructor
public class FilmService {

    private final InMemoryUserRepository userRepository = new InMemoryUserRepository();

    public Collection<Film> getAllFilms(){
    return userRepository.getAllfilms();
    }

    public <Film> addFilm(Film film){
        return userRepository.add(film);
    }



}
