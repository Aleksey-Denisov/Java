package ru.gbhw.java.controller;

public class CustomerException extends RuntimeException{
    public CustomerException(){
        this("Такого покупателя не существует");
    }

    public CustomerException(String string) {
        super(string);
    }

}
