package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    //Поля
    @Autowired
    private UserService userService;
    @Autowired
    private NotificationService notificationService;
    @Autowired
    private DataProcessingService dataProcessingService;
    //Вернуть ссылку на сервис
    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }
    //Регистрация пользователя через поля пользователя (для HTTP)
    public void processRegistration(String name, int age, String email){
        processRegistration(userService.createUser(name, age, email));
    }
    //Регистрация пользователя
    public void processRegistration(User user){
        notificationService.notifyUser(user);
        dataProcessingService.addUser(user);
    }
}
