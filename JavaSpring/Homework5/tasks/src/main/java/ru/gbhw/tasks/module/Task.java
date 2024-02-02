package ru.gbhw.tasks.module;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Task {
    //Поля. Чуть увеличил структуру
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "short_description", nullable = false)
    private String shortDesc;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private TaskStatus status;
    @Column(name = "creation_date", nullable = false)
    private LocalDateTime createTaskDate;
    //Пустой конструктор, без него ругается
    public Task() {}
    //Конструктор принимающий такой же тип, в основном для задания времени на данный момент
    public Task(Task task) {
        this.shortDesc = task.getShortDesc();
        this.description = task.getDescription();
        this.status = task.getStatus();
        this.createTaskDate = LocalDateTime.now();
    }

}
