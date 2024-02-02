package ru.gbhw.userlinkproj.controllers;

import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.gbhw.userlinkproj.models.Project;
import ru.gbhw.userlinkproj.models.User;
import ru.gbhw.userlinkproj.models.UserProject;
import ru.gbhw.userlinkproj.service.ProjectService;
import ru.gbhw.userlinkproj.service.UserProjectService;
import ru.gbhw.userlinkproj.service.UserService;

import java.util.ArrayList;
import java.util.List;

//Контроллер управления связями проект - пользователь
@Controller
@RequestMapping("/ups")
@AllArgsConstructor
public class UserProjectController {
    //Сервисы
    private final UserProjectService service;
    private final UserService userService;
    private final ProjectService projectService;
    //Получение списка пользователей по идентификатору проекта
    @GetMapping("/proj{projectId}")
    public ResponseEntity<List<User>> getUsersByProjectId(@PathVariable Long projectId) {
        //Немножко дубово, кажется что есть аналогичное решение с вложенным запросом SQL
        List<UserProject> ups = service.getUsersByProjectId(projectId);
        List<User> users = new ArrayList<>();
        ups.forEach(up -> {
            User user = userService.getUserById(up.getUserId());
            if(user != null)
                users.add(user);
        });
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    //Получение списка проектов по идентификатору пользователя
    @GetMapping("/user{userId}")
    public ResponseEntity<List<Project>> getProjectsByUserId(@PathVariable Long userId) {
        List<UserProject> ups = service.getProjectsByUserId(userId);
        List<Project> projects = new ArrayList<>();
        ups.forEach(up -> {
            Project project = projectService.getProjectById(up.getProjectId());
            if(project != null)
                projects.add(project);
        });
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }
    //Немного не уверен на счет правильности данных решений, так же думаю есть и другие пути
    //Добавление связи пользователь - проект
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ResponseEntity<Void> addUserToProject(@PathParam(value = "userId") Long userId,
                                           @PathParam(value = "projectId") Long projectId) {
        service.addUserToProject(userId, projectId);
        return ResponseEntity.ok().build();
    }
    //Удаление связи пользователь - проект
    @RequestMapping(value = "/del", method = RequestMethod.GET)
    public ResponseEntity<Void> removeUserFromProject(@PathParam(value = "userId") Long userId,
                                                @PathParam(value = "projectId") Long projectId) {
        service.removeUserFromProject(userId, projectId);
        return ResponseEntity.ok().build();
    }
}
