package ru.gbhw.java.philosophers;

public class Main {
    public static void main(String[] args) {
        new Philosophers(new String[]{"Пифагор", "Платон", "Сократ", "Цицерон", "Кант"}, 600, 10, 6).beg();;
    }
}
