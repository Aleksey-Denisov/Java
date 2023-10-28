package ru.gbhw.java.employee;

import java.util.*;
import java.util.stream.*;

public class Employees {
    private ArrayList<Employee> employees;
    
    public Employees(){
        employees = new ArrayList<>();
    }

    public Employees(ArrayList<Employee> employees){
        this.employees = employees;
    }

    public void addEmployee(Employee employee){
        employees.add(employee);
    }

    public int getSize(){
        return employees.size();
    }

    public void print(){
        for(Employee employee : employees){
            System.out.println(employee.toString());
        }
    }
    public void printPhone(){
        for(Employee employee : employees){
            System.out.println(employee.getPhone());
        }
    }

    public Employees findEmployeesByExperience(int experience){
        return (new Employees((ArrayList<Employee>)(employees.stream()
                .filter(employee -> employee.getExperience() == experience).collect(Collectors.toList()))));
    }

    public Employees findEmployeesByName(String name){
        return (new Employees((ArrayList<Employee>)(employees.stream()
                .filter(employee -> employee.getName().equals(name)).collect(Collectors.toList()))));
    }

    public Employees findEmployeesById(int id){
        return  (new Employees((ArrayList<Employee>)(employees.stream()
                .filter(employee -> employee.getId() == id).collect(Collectors.toList()))));
    }
}
