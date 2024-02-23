package ru.gbhw.tasks.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.gbhw.tasks.module.Task;
import ru.gbhw.tasks.module.TaskStatus;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskDBTest {
    //Данный тест предназначен для проверки работы записи и чтения из БД
    @Autowired
    private TaskService service;
    private Task task1, task2;
    //Инициализация моделей
    @Before
    public void init() {
        task1 = new Task();
        task1.setId(1L);
        task1.setShortDesc("test");
        task1.setDescription("test-test");
        task1.setStatus(TaskStatus.IN_PROGRESS);
        task1.setCreateTaskDate(LocalDateTime.now());

        task2 = new Task();
        task2.setId(2L);
        task2.setShortDesc("test2");
        task2.setDescription("test-test2");
        task2.setStatus(TaskStatus.NOT_STARTED);
        task2.setCreateTaskDate(LocalDateTime.now());
    }

    @Test
    public void taskDBTest() {
        //Добавляем модель и проверим что вернулось не пустое значение
        Task createTask = service.add(task1);
        assertNotNull(createTask);
        //Спросим все имеющиеся модели
        List<Task> tasksAll = service.findAll();
        assertNotNull(tasksAll);
        //Запросим статусы
        List<Task> tasksSt = service.getTaskByStatus(task1.getStatus());
        assertNotNull(tasksSt);
        //Обновим модель по идентификатору
        Task updateTask = service.updateById(task1.getId(), task2);
        assertNotNull(updateTask);
        //Удаляем модель из БД
        service.deleteById(updateTask.getId());
        Task deleteTask = service.findById(updateTask.getId());
        //Соответственно ничего по данному идентификатору уже нет
        assertNull(deleteTask);
    }
}
