package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    //Функция возвращает сообщение в консоль
    public void notifyUser(User user) {
        System.out.println("A new user has been created: " + user.getName());
    }
}
