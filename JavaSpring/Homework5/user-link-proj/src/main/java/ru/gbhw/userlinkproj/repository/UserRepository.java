package ru.gbhw.userlinkproj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gbhw.userlinkproj.models.User;

//Репозиторий для пользователей
public interface UserRepository extends JpaRepository<User, Long> {
}
