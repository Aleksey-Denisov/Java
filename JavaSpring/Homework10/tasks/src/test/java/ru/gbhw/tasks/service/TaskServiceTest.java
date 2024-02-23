package ru.gbhw.tasks.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import ru.gbhw.tasks.module.Task;
import ru.gbhw.tasks.module.TaskStatus;
import ru.gbhw.tasks.repository.TaskRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskServiceTest {
    @MockBean
    private TaskRepository repository;
    @Autowired
    private TaskService service;
    private Task task1, task2;

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
    public void addTask() {
        //Добавляю задачу через сервис
        service.add(task1);
        //Проверки поведения и спрашиваю обращались ли к репозиторию
        given(repository.findById(task1.getId())).willReturn(Optional.of(task1));
        verify(repository, times(1)).save(task1);
        when(repository.findById(task1.getId())).thenReturn(Optional.of(task1));
    }

    @Test
    public void findAllTest() {
        //Тест с запросом списка
        List<Task> tasks = service.findAll();
        verify(repository, times(1)).findAll();
        doReturn(tasks).when(repository).findAll();
    }

    @Test
    public void getStatusTest() {
        //Тест с запросом списка задач по статусу
        List<Task> tasks = service.getTaskByStatus(task1.getStatus());
        verify(repository, times(1)).getTaskByStatus(task1.getStatus());
        doReturn(tasks).when(repository).getTaskByStatus(task1.getStatus());
    }

    @Test
    public void updateTaskTest() {
        //Тест на изменение задачи
        service.updateById(task1.getId(), task2);
        verify(repository, times(1))
                .updateTaskById(task2.getShortDesc(), task2.getDescription(), task2.getStatus(), task1.getId());
    }

    @Test
    public void deleteTaskTest() {
        //Удаление задачи
        service.deleteById(task1.getId());
        verify(repository, times(1)).deleteById(task1.getId());
    }
}
