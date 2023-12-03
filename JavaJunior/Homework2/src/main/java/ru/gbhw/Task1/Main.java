package main.java.ru.gbhw.Task1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Animal[] animals = {new Cat("Барсик", 2), new Dog("Шарик", 3), new Cat("Пушок", 4)};
        Arrays.stream(animals).forEach(animal -> {
            new InfoClass(animal);
        });
    }
    
}
