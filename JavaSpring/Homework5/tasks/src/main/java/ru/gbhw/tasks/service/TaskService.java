package ru.gbhw.tasks.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gbhw.tasks.module.Task;
import ru.gbhw.tasks.module.TaskStatus;
import ru.gbhw.tasks.repository.TaskRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {
    //Репозиторий
    private final TaskRepository taskRepository;
    //Перенаправление функции добавления в репозиторий
    public Task add(Task task) {
        return taskRepository.save(task);
    }
    //Запрос всех задач из репозитория
    public List<Task> findAll() {
        return taskRepository.findAll();
    }
    //Запрос задач по статусу
    public List<Task> getTaskByStatus(TaskStatus status) {
        return taskRepository.getTaskByStatus(status);
    }
    //Транзакция на обновление данных
    @Transactional
    public Task updateById(Long id, Task task) {
        taskRepository.updateTaskById(task.getShortDesc(), task.getDescription(), task.getStatus(), id);
        return taskRepository.findById(id).get();
    }
    //Удаление задачи по идентефикатору
    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }
}
