package ru.gbhw.java.controller;

import ru.gbhw.java.model.Employee;
import ru.gbhw.java.model.EmployeeList;
import ru.gbhw.java.model.SuperVisor;

public class EmployeeController {
    private EmployeeList list;
    public EmployeeController(){
        //1
        list = new EmployeeList();
        addList();
        list.promotion(45, 5000);
        Employee.promotion(list.getList(), 35, 1500);
        list.averageAge(list.getList());
        list.averageSalary(list.getList());
        //2
        list.addEmployee(new SuperVisor("Бузина Елена Игоревна", "Руководитель", "+79841155510", 50000, 35));
        SuperVisor.promotion(list.getList(), 5000);
        list.print();
    }
    private void addList(){
        list.addEmployee(new Employee("Петров Петр Петрович", "Слесарь", "+7985054353", 35000, 47));
        list.addEmployee(new Employee("Иванов Иван Иванович", "Уборщик", "8800553535", 20000, 28));
        list.addEmployee(new Employee("Сидоров Антон Валентинович", "Старший слесарь", "+79531505332", 40000, 35));
        list.addEmployee(new Employee("Смирнов Владимир Юрьевич", "Разнорабочий", "+79120153542", 30000, 22));
        list.addEmployee(new Employee("Маркова Екатерина Сергеевна", "Бухгалтер", "+79251351812", 25000, 46));
    }
}
