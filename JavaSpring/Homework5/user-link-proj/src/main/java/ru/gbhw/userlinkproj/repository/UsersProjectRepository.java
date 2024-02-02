package ru.gbhw.userlinkproj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ru.gbhw.userlinkproj.models.UserProject;

import java.util.List;

//Репозиторий для связки проектов и пользователй
public interface UsersProjectRepository extends JpaRepository<UserProject, Long> {
    //Данная функция возвращает список пользователей по идентефикатору проекта
    @Modifying
    @Query("select up from UserProject up where up.projectId = ?1")
    List<UserProject> getByProjectId(Long projectId);

    //Данная функция возвращает список проектов по идентефикатору пользователя
    @Modifying
    @Query("select up from UserProject up where up.userId = ?1")
    List<UserProject> getByUserId(Long userId);

    //Удаление записи по айди пользователя и проекта
    @Modifying
    @Query("delete from UserProject up where up.userId = ?1 and up.projectId = ?2")
    void removeUserFromProject(Long userId, Long projectId);
}
