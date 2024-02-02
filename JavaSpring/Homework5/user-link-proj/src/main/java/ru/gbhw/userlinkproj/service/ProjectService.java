package ru.gbhw.userlinkproj.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gbhw.userlinkproj.models.Project;
import ru.gbhw.userlinkproj.repository.ProjectRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ProjectService {
    //Репозиторий проектов
    private final ProjectRepository projectRepository;
    //private final UsersProjectRepository upRepository;
    //Добавление
    public Project add(Project project) {
        return projectRepository.save(project);
    }
    //Изменение
    public Project update(Project project) {
        return projectRepository.save(project);
    }
    //Достать все проекты
    public List<Project> findAll() {
        return projectRepository.findAll();
    }
    //Достать конкретный проект
    public Project getProjectById(Long id) {
        return projectRepository.findById(id).orElseThrow(null);
    }
    //Удалить конкретный проект
    public void deleteById(Long id) {
        projectRepository.deleteById(id);
        //Аналогично с пользователем, пока каскада не будет
        //upRepository.deleteByUserId(id);
    }
}
