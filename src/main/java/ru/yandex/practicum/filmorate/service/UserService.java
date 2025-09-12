package ru.yandex.practicum.filmorate.service;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import ru.yandex.practicum.filmorate.model.User;
import ru.yandex.practicum.filmorate.repository.InMemoryUserRepository;
import ru.yandex.practicum.filmorate.repository.UserRepository;

import java.util.Collection;

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

}
