package ru.yandex.practicum.filmorate.repository;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ru.yandex.practicum.filmorate.exceptions.NotFoundException;
import ru.yandex.practicum.filmorate.model.Film;
import ru.yandex.practicum.filmorate.model.Genre;
import ru.yandex.practicum.filmorate.model.Mpa;
import ru.yandex.practicum.filmorate.repository.mappers.FilmRowMapper;
import ru.yandex.practicum.filmorate.repository.mappers.GenreRowMapper;
import ru.yandex.practicum.filmorate.repository.mappers.MpaRowMapper;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.Collection;
import java.util.List;

@Repository
@Primary
@AllArgsConstructor

public class DbFilmRepository implements FilmRepository {

    private final JdbcTemplate jdbc;
    private final FilmRowMapper filmRowMapper;
    private final GenreRowMapper genreRowMapper;
    private final MpaRowMapper  mpaRowMapper;

    @Override
    public Film addFilm(Film film) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql = "INSERT INTO films (name, description, release_date, duration) VALUES (?, ?, ?,?)";

        jdbc.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, new String[]{"id"});
            ps.setString(1, film.getName());
            ps.setString(2, film.getDescription());
            ps.setDate(3, Date.valueOf(film.getReleaseDate()));
            ps.setLong (4, film.getDuration());
            return ps;
        }, keyHolder);
        Long generatedId = keyHolder.getKey().longValue();
        film.setId(generatedId);
        return film;
    }

    @Override
    public Collection<Film> getAllFilms() {
        String sql = "SELECT * FROM films;";
        List <Film> films = jdbc.query(sql, filmRowMapper);
        return films;
    }

    @Override
    public Film updateFilm(Film newFilm) {
        Film film = new Film();
        String checkSql = "SELECT COUNT(*) FROM films WHERE id = ?";
        Integer count = jdbc.queryForObject(checkSql, Integer.class, newFilm.getId());

        if (count == null || count == 0) {
            throw new NotFoundException("Film with id " + newFilm.getId() + " not found");}

        String sql = "Update films Set name = ?, description = ?, release_date = ?, duration = ? WHERE id =?";
        jdbc.update(sql, newFilm.getName(), newFilm.getDescription(), newFilm.getReleaseDate(), newFilm.getDuration(), newFilm.getId());

        return newFilm;
    }

    @Override
    public Film getFilmById(Long id) {
        String sql = "SELECT * FROM films WHERE id = ?;";
        Film film = jdbc.queryForObject(sql, filmRowMapper, id);
        return film;
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

    @Override
    public Collection<Film> getPopularFilms(Long count) {
        return List.of();
    }

    @Override
    public Collection<Genre> getGenres() {
        String sql = "SELECT * FROM genres;";
        List <Genre> genres = jdbc.query(sql, genreRowMapper);
        return List.of();
    }

    @Override
    public Genre getGenresById(Long id) {
        String sql = "Select * FROM genres WHERE id =?;";
        Genre genre  = jdbc.queryForObject(sql, genreRowMapper,id);
        return genre;
    }

    @Override
    public Collection<Mpa> getMpas() {
        String sql = "SELECT * FROM mpa;";
        List<Mpa> mpas = jdbc.query(sql,mpaRowMapper);
        return mpas;
    }

    @Override
    public Mpa getMpaById(Long id) {
        String sql = "SELECT * FROM mpa WHERE id = ?;";
        Mpa mpa = jdbc.queryForObject(sql,mpaRowMapper, id);
        return mpa;
    }
}
