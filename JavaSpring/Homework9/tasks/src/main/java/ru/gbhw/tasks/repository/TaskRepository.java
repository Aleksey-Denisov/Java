package ru.gbhw.tasks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ru.gbhw.tasks.model.Task;
import ru.gbhw.tasks.model.TaskStatus;
import java.util.List;

public interface TaskRepository  extends JpaRepository<Task, Long> {
    //Достанем все задачи по статусу
    List<Task> getTaskByStatus(TaskStatus status);
    //Измененная функция обновления данных по айди
    @Modifying
    @Query("update Task f set f.shortDesc = ?1, f.description = ?2, f.status = ?3 where f.id = ?4")
    void updateTaskById(String shortDesc, String description, TaskStatus status, Long id);
}
