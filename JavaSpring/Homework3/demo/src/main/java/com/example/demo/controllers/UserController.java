package com.example.demo.controllers;

import com.example.demo.model.User;
import com.example.demo.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    //Поле
    @Autowired
    private RegistrationService service;
    //Получаем список всех пользователей
    @GetMapping
    public List<User> userList() {
        return service.getDataProcessingService().getRepository().findAll();
    }
    //Добавление пользователя
    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user) {
        service.processRegistration(user);
        return "User added from body!";
    }
    //Добавление пользователя через HTTP запрос
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String userAddFromParam(@RequestParam(value = "name", defaultValue = "unknown") String name,
                                   @RequestParam(value = "age", defaultValue = "0") int age,
                                   @RequestParam(value = "email", defaultValue = "unknown") String email) {
        service.processRegistration(name, age, email);
        return "User added from HTTP request!";
    }
}
