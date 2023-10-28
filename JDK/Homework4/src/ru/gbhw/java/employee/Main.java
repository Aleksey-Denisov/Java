package ru.gbhw.java.employee;

public class Main {
    public static void main(String[] args) {
        Employees employees = new Employees();
        employees.addEmployee(new Employee(employees.getSize(), 1, "test", "88005553535"));
        employees.addEmployee(new Employee(employees.getSize(), 5, "test2", "89315105413"));
        employees.addEmployee(new Employee(employees.getSize(), 10, "test3", "89153433512"));
        employees.addEmployee(new Employee(employees.getSize(), 5, "test", "89545131553"));

        System.out.println("Сотрудники по стажу 5 лет: ");
        employees.findEmployeesByExperience(5).print();

        System.out.println("Телефон сотрудника по имени: test");
        employees.findEmployeesByName("test").printPhone();
        
        System.out.println("Поиск сотрудника по табельному номеру: 2");
        employees.findEmployeesById(2).print();
    }
}
