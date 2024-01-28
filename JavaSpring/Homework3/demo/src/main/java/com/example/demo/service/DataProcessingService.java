package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataProcessingService {
    @Autowired
    private UserRepository repository;

    public UserRepository getRepository() {
        return repository;
    }
    //Функция сортировки пользователей по возрасту
    public List<User> sortUsersByAge(List<User> users) {
        return users.stream().sorted(Comparator.comparing(User::getAge)).collect(Collectors.toList());
    }

    //Функция фильтрации списка пользователей по возрасту.
    //Вернет всех кто старше заданного возраста
    public List<User> filterUsersByAge(List<User> users, int age) {
        return users.stream().filter(user -> user.getAge() > age).collect(Collectors.toList());
    }

    //Функция возвращает средний возраст из списка
    public double calculateAverageAge(List<User> users) {
        return users.stream().mapToInt(User::getAge).average().orElse(0);
    }

    public void addUser(User user) {
        repository.save(user);
    }
}
