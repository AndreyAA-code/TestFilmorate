package ru.yandex.practicum.filmorate.repository;

import org.postgresql.ds.PGConnectionPoolDataSource;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import ru.yandex.practicum.filmorate.model.User;

import javax.sql.PooledConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Repository
@Primary
public class UserDbRepository implements UserRepository {
    @Override
    public Collection<User> getAllUsers() {
   /*     String url = "jdbc:postgresql://localhost:5432/filmorate";
        String user = "sa";
        String password = "password";

        PGConnectionPoolDataSource ds = new PGConnectionPoolDataSource();
        ds.setURL(url);
        ds.setUser(user);
        ds.setPassword(password);
        PooledConnection pooledConnection = null;
        try {
            pooledConnection = ds.getPooledConnection();
            String sql = "SELECT * FROM users;";
            PreparedStatement preparedStatement = pooledConnection.getConnection().prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getLong("id"));
                System.out.println(rs.getString("name"));
                System.out.println(rs.getString("email"));
                System.out.println(rs.getDate("birthday"));
                User user1 = new User();
                user1.setId(rs.getLong("id"));
                user1.setName(rs.getString("name"));
                user1.setEmail(rs.getString("email"));
                user1.setBirthday(rs.getDate("birthday").toLocalDate());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } */
        return List.of();
    }

    @Override
    public User getUserById(Long id) {
        String url = "jdbc:postgresql://localhost:5432/filmorate";
        String user = "sa";
        String password = "password";
        User user1 = new User();
        PGConnectionPoolDataSource ds = new PGConnectionPoolDataSource();
        ds.setURL(url);
        ds.setUser(user);
        ds.setPassword(password);
        PooledConnection pooledConnection = null;
        try {
            pooledConnection = ds.getPooledConnection();
            String sql = "SELECT * FROM users;";
            PreparedStatement preparedStatement = pooledConnection.getConnection().prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getLong("id"));
                System.out.println(rs.getString("login"));
                System.out.println(rs.getString("name"));
                System.out.println(rs.getString("email"));
                System.out.println(rs.getDate("birthday"));

                user1.setId(rs.getLong("id"));
                user1.setLogin(rs.getString("login"));
                user1.setName(rs.getString("name"));
                user1.setEmail(rs.getString("email"));
                user1.setBirthday(rs.getDate("birthday").toLocalDate());
                System.out.println(user1);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        User user2 = new User();
        return user1;
    }

    @Override
    public User createUser(User user) {
        return null;
    }

    @Override
    public User updateUser(User user) {
        return null;
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
        return List.of();
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
