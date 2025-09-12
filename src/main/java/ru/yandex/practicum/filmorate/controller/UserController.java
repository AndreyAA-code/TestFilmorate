package ru.yandex.practicum.filmorate.controller;

import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import ru.yandex.practicum.filmorate.model.User;
import ru.yandex.practicum.filmorate.service.UserService;

import java.util.Collection;

@RestController()
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    public final UserService userService;

    @GetMapping
    public Collection<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@Valid  @PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/{id}/friends")
    public Collection<Long> getUserFriends (@Valid @PathVariable Long id) {
        return userService.getUserFriends(id);
    }

    @PostMapping
    public User createUser(@Valid @RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping
    public User updateUser(@Valid @RequestBody User user) {
        return userService.updateUser(user);
    }

    @PutMapping("/{id}/friends/{friendId}")
    public Long updateUserFriends(@Valid @PathVariable Long id, @Valid @PathVariable Long friendId) {
        return userService.updateUserFriends(id,friendId);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@Valid @RequestBody Long id) {
        userService.deleteUser(id);
    }







}
