package ru.gbhw.java.calculator;

public class Main {
    public static void main(String[] args) {
        System.out.println(Calculator.divide(54.34, 13.345));
        System.out.println(Calculator.sum((short) 5, 187L));
        System.out.println(Calculator.multiply((byte) 3, 7.4f));
        System.out.println(Calculator.subtraction((long) 23, (short) 15));
        Byte[] arr1 = {1, 0b10, 3, 4, 5};
        Byte[] arr2 = {1, 2, 3, 4, 5};
        Long[] arr3 = {1L, 2L, 3L, 4L, 5L};
        Long[] arr4 = {1L, 2L, 3L, 4L, 6L};
        System.out.println(Calculator.compareArrays(arr1, arr2));
        System.out.println(Calculator.compareArrays(arr3, arr4));
        System.out.println(new Pair<>("Hello", 123).toString());
    }
}
