package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;


    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //Адресуем запросы в репозиторий
    //Запрос получения всех данных
    public List<User> findAll() {
        return userRepository.findAll();
    }
    //Запрос сохранения пользователя
    public User saveUser(User user) {
        return userRepository.save(user);
    }
    //Запрос удаления пользователя
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }
    //Запрос изменения пользователя
    public User update(User user) {
        return userRepository.update(user);
    }
}
