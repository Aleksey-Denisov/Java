package ru.gbhw.userlinkproj.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gbhw.userlinkproj.models.UserProject;
import ru.gbhw.userlinkproj.repository.UsersProjectRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class UserProjectService {
    //Репозиторий
    private final UsersProjectRepository usersProjectRepository;
    //Вернуть список пользователей привязанных к проекту
    public List<UserProject> getUsersByProjectId(Long projectId) {
        return usersProjectRepository.getByProjectId(projectId);
    }
    //Вернуть список проектов привязанных к пользователю
    public List<UserProject> getProjectsByUserId(Long userId) {
        return usersProjectRepository.getByUserId(userId);
    }
    //Добавить связь проект - пользователь
    public void addUserToProject(Long projectId, Long userId) {
        UserProject up = new UserProject();
        up.setRelatedEntityId(1L);
        up.setProjectId(projectId);
        up.setUserId(userId);
        usersProjectRepository.save(up);
    }
    //Удалить связь пользователь - проект
    @Transactional
    public void removeUserFromProject(Long userId, Long projectId) {
        usersProjectRepository.removeUserFromProject(userId, projectId);
    }

}
