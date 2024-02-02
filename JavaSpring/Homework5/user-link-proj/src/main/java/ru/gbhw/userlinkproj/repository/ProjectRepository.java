package ru.gbhw.userlinkproj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gbhw.userlinkproj.models.Project;

//Репозиторий для проектов
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
