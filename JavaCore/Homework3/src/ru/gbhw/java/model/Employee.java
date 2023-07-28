package ru.gbhw.java.model;

import java.util.ArrayList;

public class Employee {
    private String fio;
    private String position;
    private String phoneNumber;
    private int salary;
    private int age;

    public Employee(String fio, String position, String phoneNumber, int salary, int age){
        this.fio = fio;
        this.position = position;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }
    public void setFio(String fio){
        this.fio = fio;
    }
    public String getFio(){
        return fio;
    }
    public void setPosition(String position){
        this.position = position;
    }
    public String getPosition(){
        return position;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public void setSalary(int salary){
        this.salary = salary;
    }
    public int getSalary(){
        return salary;
    }
    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return age;
    }
    @Override
    public String toString(){
        return "ФИО: " + fio + "\nДолжность: " + position + "\nНомер телефона: " + phoneNumber + "\nЗарплата: " + salary + "\nВозраст: " + age + "\n";
    }
    public static void promotion(ArrayList<Employee> employees, int age, int salary){
        for(Employee employee : employees){
            if(employee.getAge() > age)
                employee.setSalary(employee.getSalary() + salary);
        }
    }
}
