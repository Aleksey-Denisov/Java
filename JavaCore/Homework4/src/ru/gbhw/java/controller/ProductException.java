package ru.gbhw.java.controller;

public class ProductException extends RuntimeException{
    public ProductException(){
        this("Данного товара не существует");
    }

    public ProductException(String string) {
        super(string);
    }

}
