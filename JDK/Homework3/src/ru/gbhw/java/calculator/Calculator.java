package ru.gbhw.java.calculator;

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
        return num1.doubleValue() / num2.doubleValue();
    }

    public static <T extends Number, V extends Number> boolean compareArrays(T[] arr1, V[] arr2){
        if(arr1.length == arr2.length){
            for(int idElement = 0; idElement < arr1.length; idElement++){
                if(arr1[idElement].doubleValue() != arr2[idElement].doubleValue()){
                    return false;
                }
            }
            return true;
        }
        else
            return false;
    }
}
