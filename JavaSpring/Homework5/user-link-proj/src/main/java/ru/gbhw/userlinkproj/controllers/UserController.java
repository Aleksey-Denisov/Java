package ru.gbhw.userlinkproj.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gbhw.userlinkproj.models.User;
import ru.gbhw.userlinkproj.service.UserService;

import java.util.List;

//Контроллер управления пользователями
@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    //Сервис
    private final UserService userService;
    //Добавить пользователя
    @PostMapping
    public User addUser(@RequestBody User user) {
        return userService.add(user);
    }
    //Получить всех пользователей
    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }
    //Изменить пользователя
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        User updateUser = new User();
        updateUser.setId(id);
        updateUser.setName(user.getName());
        updateUser.setPassword(user.getPassword());
        updateUser.setEmail(user.getEmail());
        updateUser.setRole(user.getRole());
        return userService.update(updateUser);
    }
    //Удалить пользователя
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
    }
}
