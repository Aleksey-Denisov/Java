package ru.gbhw.java.calculator;

import java.io.IOException;

public class Calculator {
    public static <T extends Number, V extends Number> double sum(T num1, V num2) {
        return num1.doubleValue() + num2.doubleValue();
    }

    public static <T extends Number, V extends Number> double multiply(T num1, V num2) {
        return num1.doubleValue() * num2.doubleValue();
    }

    public static <T extends Number, V extends Number> double subtraction(T num1, V num2) {
        return num1.doubleValue() - num2.doubleValue();
    }

    public static <T extends Number, V extends Number> double divide(T num1, V num2) {
        try{
            if(num2.doubleValue() == 0)
                throw new IOException("Деление на ноль запрещено");
            return num1.doubleValue() / num2.doubleValue();
        }catch(IOException e){
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public static <T extends Comparable<T>> boolean compareArrays(T[] arr1, T[] arr2){
        if(arr1.length == arr2.length){
            for(int idElement = 0; idElement < arr1.length; idElement++){
                if(!arr1[idElement].equals(arr2[idElement])){
                    return false;
                }
            }
            return true;
        }
        else
            return false;
    }
}
