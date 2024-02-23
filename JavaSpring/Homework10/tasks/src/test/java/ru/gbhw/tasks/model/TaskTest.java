package ru.gbhw.tasks.model;

import org.junit.Test;
import ru.gbhw.tasks.module.Task;
import ru.gbhw.tasks.module.TaskStatus;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskTest {
    @Test
    public void taskTest() {
        //Данный тест позволяет проверить методы чтения и записи модели
        //Добавление модели
        LocalDateTime timeTask = LocalDateTime.now();
        Task task1 = new Task();
        task1.setId(1L);
        task1.setShortDesc("test");
        task1.setDescription("test-test");
        task1.setStatus(TaskStatus.IN_PROGRESS);
        task1.setCreateTaskDate(timeTask);
        //Сравнение с тем что задали
        assertEquals(task1.getId(), 1L);
        assertEquals(task1.getShortDesc(), "test");
        assertEquals(task1.getDescription(), "test-test");
        assertEquals(task1.getStatus(), TaskStatus.IN_PROGRESS);
        assertEquals(task1.getCreateTaskDate(), timeTask);
    }
}
