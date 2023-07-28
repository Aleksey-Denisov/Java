package ru.gbhw.java.model;

import java.util.ArrayList;

public class EmployeeList {
    private ArrayList<Employee> employees;
    public EmployeeList(){
        employees = new ArrayList<>();
    }
    public void addEmployee(Employee employee){
        employees.add(employee);
    }
    public void print(){
        for(Employee employee : employees){
            System.out.println(employee);
        }
    }
    public void promotion(int age, int salaryIncrease){
        for(Employee employee : employees){
            if(employee.getAge() > age)
                employee.setSalary(employee.getSalary() + salaryIncrease);
        }
    }
    public ArrayList<Employee> getList(){
        return employees;
    }
    public void averageAge(ArrayList<Employee> employees){
        int avgAge = 0;
        for(Employee employee : employees){
            avgAge += employee.getAge();
        }
        System.out.println("Средний возраст сотрудников: " + (avgAge /= employees.size()));
    }
    public void averageSalary(ArrayList<Employee> employees){
        int avgSalary = 0;
        for(Employee employee : employees){
            avgSalary += employee.getSalary();
        }
        System.out.println("Средняя зарпалата сотрудников: " + (avgSalary /= employees.size()));
    }
}
