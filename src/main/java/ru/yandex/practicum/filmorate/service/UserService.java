package ru.yandex.practicum.filmorate.service;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import ru.yandex.practicum.filmorate.model.User;
import ru.yandex.practicum.filmorate.repository.InMemoryUserRepository;
import ru.yandex.practicum.filmorate.repository.UserRepository;

import java.util.Collection;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

   // @Qualifier("InMemoryUserRepository")
    public final UserRepository userRepository;

    public Collection<User> getAllUsers () {
        return userRepository.getAllUsers();
    }

    public User getUserById (Long id) {
       return userRepository.getUserById(id);
    }

    public User createUser(User user) {
        return userRepository.createUser(user);
    }

    public User updateUser(User user) {
        return userRepository.updateUser(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteUser(id);
    }

    public List<User> getUserFriends (Long id) {
       return userRepository.getUserFriends(id);
    }

    public List<User> updateUserFriends(Long id, Long friendId) {
        return userRepository.updateUserFriends(id, friendId);
    }

    public List<User> deleteUserFriends(Long id, Long friendId) {
        return userRepository.deleteUserFriends(id,friendId);
    }

    public List<User> getCommonFriends(Long id, Long otherId) {
        return userRepository.getCommonFriends(id, otherId);
    }

}
