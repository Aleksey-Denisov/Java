package main.java.ru.gbhw.Task1;

import java.lang.reflect.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Animal[] animals = {new Cat("Барсик", 2), new Dog("Шарик", 3), new Cat("Пушок", 4)};
        for(Animal animal : animals) {
            Class<?> animalClass = animal.getClass();
            System.out.println("Информация о классе: " + animalClass.getSimpleName() + ", имеет следующие поля:");
            showAllFields(animal, animalClass);
            showAllConstructors(animalClass);
            showAllMethods(animal, animalClass);
        }
    }
    //Функция получения всех полей в классе
    private static void showAllFields(Animal animal, Class<?> animalClass) {
        ArrayList<Field> allFields = new ArrayList<>();
        Collections.addAll(allFields, animalClass.getSuperclass().getDeclaredFields());
        Collections.addAll(allFields, animalClass.getDeclaredFields());
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
    }
    //Функция получения всех конструкторов в классе
    private static void showAllConstructors(Class<?> animalClass) {
        ArrayList<Constructor<?>> allConstructors = new ArrayList<>();
        Collections.addAll(allConstructors, animalClass.getSuperclass().getConstructors());
        Collections.addAll(allConstructors, animalClass.getConstructors());
        allConstructors.forEach(constructor -> {
            System.out.println("Конструктор: " + constructor);
        });
    }
    //Функция получения всех методов в классе
    private static void showAllMethods(Animal animal, Class<?> animalClass) {
        ArrayList<Method> allMethods = new ArrayList<>();
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
            try {
                Method method = animalClass.getDeclaredMethod("makeSound", new Class[]{});
                if (method != null)
                    System.out.println("Результат вызванной функции makeSound: " + method.invoke(animal));
            } catch (NoSuchMethodException | SecurityException | IllegalAccessException | InvocationTargetException ignored) {
            }
    }
    //Функция получения параметров в методе
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
