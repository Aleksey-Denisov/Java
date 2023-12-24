package ru.gbhw;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Course> courses = addData();
        WorkDB wDb = new WorkDB();
        wDb.recreateTable();
        courses.stream().forEach(course -> wDb.insertData(course));
        //wDb.update(33, "test", 1);
        wDb.update(4, "Математика", 48.63);
        wDb.delete(4);
        System.out.println("Select course: " + wDb.selectId(1));
        System.out.println("----------------------------------------");
        System.out.println("Select all courses: ");
        for(Course course : wDb.selectAll()) {
            System.out.println(course);
        }
    }

    static ArrayList<Course> addData() {
        ArrayList<Course> list = new ArrayList<>();
        list.add(new Course("Работа с базами данных", 2.5));
        list.add(new Course("Стоматорогия", 3.8));
        list.add(new Course("Правила дорожного движения", 6.5));
        list.add(new Course("Русский язык", 36.3));
        return list;
    }
}