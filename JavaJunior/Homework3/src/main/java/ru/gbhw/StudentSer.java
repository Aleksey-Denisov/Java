package ru.gbhw;

import java.io.Serializable;

public class StudentSer implements Serializable {
    private String name;
    private int age;
    private transient double GPA;

    public StudentSer(String name, int age, double GPA) {
        this.name = name;
        this.age = age;
        this.GPA = GPA;
    }

    public StudentSer() {
    }
    public double getGPA() {
        return GPA;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("Имя студента: %s\nВозраст: %d\nСредний балл: %f", this.getName(), this.getAge(), this.getGPA());
    }
}
