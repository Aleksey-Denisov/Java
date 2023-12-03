package main.java.ru.gbhw.Task1;

import java.lang.reflect.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Animal[] animals = {new Cat("Барсик", 2), new Dog("Шарик", 3), new Cat("Пушок", 4)};
        for(Animal animal : animals) {
            ArrayList<Field> allFields = new ArrayList<>();
            Class<?> animalClass = animal.getClass();
            Collections.addAll(allFields, animalClass.getSuperclass().getDeclaredFields());
            Collections.addAll(allFields, animalClass.getDeclaredFields());
            System.out.println("Информация о классе: " + animalClass.getSimpleName() + ", имеет следующие поля:");
            //Выведем все поля класса
            allFields.forEach(field -> {
                field.setAccessible(true);
                try {
                    //Ради эксперимента добавлю в какое нибудь поле значение
                    if(field.getName().equals("swims") && field.getType() == int.class)
                        field.set(animal, 100);
                    System.out.println("Поле класса: " + field.getName() + ", с значением: " + field.get(animal));
                } catch (IllegalArgumentException | IllegalAccessException ignored) {
                }
            });
            //Обработка методов классов
            Arrays.stream(animalClass.getDeclaredMethods()).forEach(method -> {
                if(method.getName().equals("makeSound")) {
                    try {
                        System.out.println("Результат вызванной функции makeSound: " + method.invoke(animal));
                    } catch (IllegalAccessException | InvocationTargetException ignored) {
                    }
                }
            });
        }
    }
}
