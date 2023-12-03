package main.java.ru.gbhw.Task1;

import java.lang.reflect.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Animal[] animals = {new Cat("Барсик", 2), new Dog("Шарик", 3), new Cat("Пушок", 4)};
        for(Animal animal : animals) {
            ArrayList<Field> allFields = new ArrayList<>();
            ArrayList<Constructor<?>> allConstructors = new ArrayList<>();
            ArrayList<Method> allMethods = new ArrayList<>();
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
            //Получим все конструкторы
            Collections.addAll(allConstructors, animalClass.getSuperclass().getConstructors());
            Collections.addAll(allConstructors, animalClass.getConstructors());
            allConstructors.forEach(constructor -> {
                System.out.println("Конструктор: " + constructor);
            });
            //Обработка методов классов
            Collections.addAll(allMethods, animalClass.getSuperclass().getDeclaredMethods());
            Collections.addAll(allMethods, animalClass.getDeclaredMethods());
            allMethods.forEach(method -> {
                method.setAccessible(true);
                System.out.print("Метод класса: " + method.getName());
                if (method.getParameterCount() > 0)
                    System.out.print(", с параметрами " + getParameters(method.getParameters()));
                else
                    System.out.print(", без параметров");
                if (method.getReturnType().toString().equals("void"))
                    System.out.println(" -> Без возврата");
                else 
                    System.out.println(" -> Возвращает тип " + method.getReturnType());
            });
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

    private static String getParameters(Parameter[] parameters) {
        StringBuilder result = new StringBuilder();
        result.append("(");
        Arrays.stream(parameters).forEach(parameter -> {
            result.append(parameter + ", ");
        });
        if (result.charAt(result.length() - 2) == ',')
            result.delete(result.length() - 2, result.length());
        result.append(")");
        return result.toString();
    }
}
