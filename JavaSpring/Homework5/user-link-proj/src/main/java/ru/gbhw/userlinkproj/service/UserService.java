package ru.gbhw.userlinkproj.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gbhw.userlinkproj.models.User;
import ru.gbhw.userlinkproj.repository.UserRepository;
import ru.gbhw.userlinkproj.repository.UsersProjectRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    //Репозиторий
    private final UserRepository userRepository;
    //private final UsersProjectRepository upRepository;
    //Добавление пользователя
    public User add(User user) {
       return userRepository.save(user);
    }
    //Изменение пользователя
    public User update(User user) {
        return userRepository.save(user);
    }
    //Выборка всех пользователей
    public List<User> findAll() {
        return userRepository.findAll();
    }
    //Достать конкретного пользователя
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(null);
    }
    //Удалить пользователя
    public void deleteById(Long id) {
        userRepository.deleteById(id);
        //Хотелось добавить удаление каскадом, но требуется больше проверок и условий
        //Если нужно в другой раз
        //Хотя так же можно это все сделать с помощью SQL запросов если в H2 это будет работать
        //В настройках самой таблицы
        //upRepository.deleteByUserId(id);
    }
}
