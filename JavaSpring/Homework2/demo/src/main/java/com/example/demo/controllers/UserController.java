package com.example.demo.controllers;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    //Переход на страницу приветствия
    @GetMapping("/")
    public String home() {
        return "../static/home";
    }
    //Отображение всех пользователей на странице users
    @GetMapping("/users")
    public String findAll(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "user-list";
    }
    //Открытие формы создания пользователя
    @GetMapping("/user-create")
    public String createUserForm(User user){
        return "user-create";
    }
    //Сохрание изменений и переход на страницу users
    @PostMapping("/user-create")
    public String createUser(User user){
        userService.saveUser(user);
        return "redirect:/users";
    }
    //Удаление пользователя по идентефикатору и переход обратно на страницу пользователей
    @GetMapping("/user-delete/{id}")
    public String deleteById(@PathVariable("id") int id) {
        userService.deleteById(id);
        return "redirect:/users";
    }
    //Открытие формы для изменения пользователя по идентефикатору
    @GetMapping("/user-update/{id}")
    public String updateUserForm(User user) {
        return "user-update";
    }
    //Сохранение изменений и возврат на страницу пользователей
    @PostMapping("/user-update")
    public String update(User user) {
        userService.update(user);
        return "redirect:/users";
    }
}
