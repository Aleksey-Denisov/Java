package ru.gbhw.tasks.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gbhw.tasks.aspect.TrackUserAction;
import ru.gbhw.tasks.model.Task;
import ru.gbhw.tasks.model.TaskStatus;
import ru.gbhw.tasks.repository.TaskRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {
    //Репозиторий
    private final TaskRepository taskRepository;
    //Перенаправление функции добавления в репозиторий
    @TrackUserAction
    public Task add(Task task) {
        return taskRepository.save(task);
    }
    //Запрос всех задач из репозитория
    @TrackUserAction
    public List<Task> findAll() {
        return taskRepository.findAll();
    }
    //Запрос задач по статусу
    @TrackUserAction
    public List<Task> getTaskByStatus(TaskStatus status) {
        return taskRepository.getTaskByStatus(status);
    }
    //Транзакция на обновление данных
    @TrackUserAction
    @Transactional
    public Task updateById(Long id, Task task) {
        taskRepository.updateTaskById(task.getShortDesc(), task.getDescription(), task.getStatus(), id);
        return taskRepository.findById(id).get();
    }
    //Удаление задачи по идентефикатору
    @TrackUserAction
    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }
}
