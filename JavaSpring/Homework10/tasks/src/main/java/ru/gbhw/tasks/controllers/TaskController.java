package ru.gbhw.tasks.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gbhw.tasks.module.Task;
import ru.gbhw.tasks.module.TaskStatus;
import ru.gbhw.tasks.service.TaskService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@AllArgsConstructor
public class TaskController {
    //Сервис
    private final TaskService taskService;
    //Получаем запрос на добавление задачи
    @PostMapping
    public Task addTask(@RequestBody Task task) {
        task.setCreateTaskDate(LocalDateTime.now());
        return taskService.add(task);
    }
    //Отдаем список всех задач
    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.findAll();
    }
    //Отдаем список задач по статусу
    @GetMapping("/{status}")
    public List<Task> getTaskByStatus(@PathVariable TaskStatus status) {
        return taskService.getTaskByStatus(status);
    }
    //Обновляем информацию по задаче по идентефикатору
    @PutMapping("/{id}")
    public Task updateTaskById(@PathVariable Long id, @RequestBody Task task) {
        return taskService.updateById(id, task);
    }
    //Удаляем задачу по идентефикатору
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        taskService.deleteById(id);
    }
}
