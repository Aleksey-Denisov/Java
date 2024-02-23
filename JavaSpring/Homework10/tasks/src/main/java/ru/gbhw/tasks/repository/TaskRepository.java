package ru.gbhw.tasks.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.gbhw.tasks.module.Task;
import ru.gbhw.tasks.module.TaskStatus;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Long> {
    //Достанем все задачи по статусу
    List<Task> getTaskByStatus(TaskStatus status);
    //Измененная функция обновления данных по айди
    @Modifying
    @Query("update Task f set f.shortDesc = ?1, f.description = ?2, f.status = ?3 where f.id = ?4")
    //@Query("update tasks set short_description = :shortDesc, description = :description, status =:status where id = :id")
    void updateTaskById(String shortDesc, String description, TaskStatus status, Long id);

}
