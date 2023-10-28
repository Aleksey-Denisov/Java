package ru.gbhw.java.employee;

public class Employee {
    int id, experience;
    String name, phone;

    public Employee(int id, int experience, String name, String phone){
        this.id = id;
        this.experience = experience;
        this.name = name;
        this.phone = phone;
    }
    @Override
    public String toString(){
        return "Сотрудник:\nТабельный номер: "+ id + "\nНомер телефона: " + phone + "\nИмя: " + name
             + "\nСтаж: " + experience; 
    }

    public int getId(){
        return id;
    }
    
    public int getExperience(){
        return experience;
    }

    public String getName(){
        return name;
    }

    public String getPhone(){
        return phone;
    }

}
