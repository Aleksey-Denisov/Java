package ru.gbhw.java.module;

public class Buyer {
    private String fio;
    private int age;
    private String phoneNumber;

    public Buyer(String fio, int age, String phoneNumber){
        this.fio = fio;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }
    public String getFio(){
        return fio;
    }
    public int getAge(){
        return age;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public void setFio(String fio){
        this.fio = fio;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    @Override
    public String toString(){
        return "ФИО: " + fio + "\nВозраст: " + age + "\nНомер телефона: " + phoneNumber + "\n";
    }
}
