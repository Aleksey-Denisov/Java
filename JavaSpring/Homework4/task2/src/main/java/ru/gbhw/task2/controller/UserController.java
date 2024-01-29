package ru.gbhw.task2.controller;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.gbhw.task2.model.User;
import ru.gbhw.task2.service.UserService;

@Controller
@AllArgsConstructor
@Log
public class UserController {
    //Сервис
    private UserService service;
    //Все важности логов были сделаны ради экспериментов. Никакой смысловой нагрузки не несет
    //Открытие домашней страницы
    @GetMapping
    public String getHome() {
        log.severe("Open start page");
        return "../static/home";
    }
    //Открытие страницы пользователей
    @GetMapping("/users")
    public String getUsers(Model model) {
        model.addAttribute("users", service.select());
        log.info("Open users page");
        return "user-list";
    }
    //Открытие формы создания пользователей
    @GetMapping("/user-create")
    public String createUserForm(User user) {
        return "user-create";
    }
    //Сохранение изменений в БД
    @PostMapping("/user-create")
    public String createUser(User user) {
        service.save(user);
        log.info("Create user: " + user);
        return "redirect:/users";
    }
    //Удаление пользователя по идентефикатору и переход обратно на страницу пользователей
    @GetMapping("/user-delete/{id}")
    public String deleteById(@PathVariable("id") int id) {
        service.delete(id);
        log.warning("Deleted user id = " + id);
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
        service.update(user);
        log.warning("Updated user: " + user);
        return "redirect:/users";
    }

}
