package ru.gbhw.userlinkproj.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gbhw.userlinkproj.models.Project;
import ru.gbhw.userlinkproj.service.ProjectService;

import java.time.LocalDate;
import java.util.List;

//Контроллер управления проектами
@RestController
@RequestMapping("/projects")
@AllArgsConstructor
public class ProjectController {
    //Сервис
    private final ProjectService projectService;
    //Добавление проекта
    @PostMapping
    public Project addProject(@RequestBody Project project) {
        project.setCreatedDate(LocalDate.now());
        return projectService.add(project);
    }
    //Показать все проекты
    @GetMapping
    public List<Project> findAll() {
        return projectService.findAll();
    }
    //Обновить данные проекта
    @PutMapping("/{id}")
    public Project updateProject(@PathVariable Long id, @RequestBody Project project) {
        Project updateProject = new Project();
        updateProject.setId(id);
        updateProject.setName(project.getName());
        updateProject.setDescription(project.getDescription());
        updateProject.setCreatedDate(project.getCreatedDate());
        return projectService.update(updateProject);
    }
    //Удалить проект
    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable Long id) {
        projectService.deleteById(id);
    }
}
