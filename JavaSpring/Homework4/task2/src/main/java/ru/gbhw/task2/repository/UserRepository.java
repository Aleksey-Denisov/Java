package ru.gbhw.task2.repository;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.gbhw.task2.model.SQLQuery;
import ru.gbhw.task2.model.User;

import java.util.List;

@Repository
@AllArgsConstructor
public class UserRepository {
    //Необходимые поля для работы
    private final JdbcTemplate jdbc;
    private final SQLQuery sql;
    //Запрос выборки всех пользователей
    public List<User> select() {
        RowMapper<User> userRowMapper = (r, i) -> {
            User user = new User();
            user.setId(r.getInt("id"));
            user.setFirstName(r.getString("firstName"));
            user.setLastName(r.getString("LastName"));
            return user;
        };
        return jdbc.query(sql.getSelect(), userRowMapper);
    }
    //Запрос добавления нового пользователя
    public void save(User user) {
        jdbc.update(sql.getInsert(), user.getFirstName(), user.getLastName());
    }
    //Удаление пользователя по идентефикатору
    public void delete(int id) {
        jdbc.update(sql.getDelete(), id);
    }
    //Сохранение изменений пользователя
    public void update(User user) {
        jdbc.update(sql.getUpdate(), user.getFirstName(), user.getLastName(), user.getId());
    }
}
