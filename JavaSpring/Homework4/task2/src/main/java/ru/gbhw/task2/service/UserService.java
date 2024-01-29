package ru.gbhw.task2.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gbhw.task2.model.User;
import ru.gbhw.task2.repository.UserRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    //Репозиторий
    private final UserRepository userRepository;
    //Переадресация и возврат запроса выборки
    public List<User> select() {
        return userRepository.select();
    }
    //Переадресация сохранения пользователя
    public void save(User user) {
        userRepository.save(user);
    }
    //Удаление пользователя
    public void delete(int id) {
        userRepository.delete(id);
    }
    //Обновление данных пользователя
    public void update(User user) {
        userRepository.update(user);
    }
}
