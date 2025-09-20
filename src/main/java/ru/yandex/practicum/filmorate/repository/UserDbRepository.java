package ru.yandex.practicum.filmorate.repository;

import lombok.AllArgsConstructor;
import org.postgresql.ds.PGConnectionPoolDataSource;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ru.yandex.practicum.filmorate.exceptions.NotFoundException;
import ru.yandex.practicum.filmorate.model.User;
import ru.yandex.practicum.filmorate.repository.mappers.UserRowMapper;

import javax.sql.PooledConnection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Repository
@AllArgsConstructor
@Primary
public class UserDbRepository implements UserRepository {
    private  JdbcTemplate jdbc;
    private final UserRowMapper mapper;

    @Override
    public Collection<User> getAllUsers() {
        String sql = "SELECT * FROM users ORDER BY id ASC";
        List<User> users = jdbc.query(sql, mapper);
        return users;
    }

    @Override
    public User getUserById(Long id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        User user = jdbc.queryForObject(sql, mapper, id);
        return user;
    }

    @Override
    public User createUser(User user) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql = "INSERT INTO users (email, login, name, birthday) VALUES (?, ?, ?, ?)";

        jdbc.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, new String[]{"id"});
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getLogin());
            ps.setString(3, user.getName());
            ps.setDate (4, Date.valueOf(user.getBirthday()));
            return ps;
        }, keyHolder);
        Long generatedId = keyHolder.getKey().longValue();
        user.setId(generatedId);
        return user;
    }

    @Override
    public User updateUser(User newUser) {

        String checkSql = "SELECT COUNT(*) FROM users WHERE id = ?";
        Integer count = jdbc.queryForObject(checkSql, Integer.class, newUser.getId());

        if (count == null || count == 0) {
            throw new NotFoundException("User with id " + newUser.getId() + " not found");}

        String sql = "Update users Set email = ?, login = ?, name = ?, birthday = ? WHERE id =?";
        jdbc.update(sql, newUser.getEmail(), newUser.getLogin(), newUser.getName(), newUser.getBirthday(), newUser.getId());

        return newUser;
    }

    @Override
    public void deleteUser(Long id) {

    }

    @Override
    public List<User> getUserFriends(Long id) {
        return List.of();
    }

    @Override
    public List<User> updateUserFriends(Long id, Long friendId) {
        String sql = "INSERT INTO friends (user_id, friend_id) VALUES (?, ?)";
        jdbc.update(sql, id, friendId);




        String sql1 = "SELECT * FROM users WHERE id = ?";
        List<User> users = jdbc.query(sql1, mapper, id);
        return users;
    }

    @Override
    public List<User> deleteUserFriends(Long id, Long friendId) {
        return List.of();
    }

    @Override
    public Set<User> getCommonFriends(Long id, Long otherId) {
        return Set.of();
    }
}
