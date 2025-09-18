package ru.yandex.practicum.filmorate.repository;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import ru.yandex.practicum.filmorate.model.User;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Repository
@Primary
public class UserDbRepository implements UserRepository {
    @Override
    public Collection<User> getAllUsers() {
        return List.of();
    }

    @Override
    public User getUserById(Long id) {
        return null;
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
