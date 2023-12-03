package main.java.ru.gbhw.Task2.models;


import main.java.ru.gbhw.Task2.Column;

import java.util.UUID;

@main.java.ru.gbhw.Task2.Entity
public class Entity {

    @Column(name = "id", primaryKey = true)
    private UUID id;

}
