package ru.gbhw;

import com.fasterxml.jackson.annotation.*;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Student implements Externalizable {
    private String name;
    private int age;
    @JsonIgnore
    private double GPA;

    public Student(String name, int age, double GPA) {
        this.name = name;
        this.age = age;
        this.GPA = GPA;
    }

    public Student() {
    }
    @JsonIgnore
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
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
        out.writeObject(age);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject();
        age = (int) in.readObject();
    }

    @Override
    public String toString() {
        return String.format("Имя студента: %s\nВозраст: %d\nСредний балл: %f", this.getName(), this.getAge(), this.getGPA());
    }
}
