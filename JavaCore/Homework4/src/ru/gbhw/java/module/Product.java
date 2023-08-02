package ru.gbhw.java.module;

public class Product {
    private String productName;
    private double price;

    public Product(String productName, double price){
        this.productName = productName;
        this.price = price;
    }
    public String getProductName(){
        return productName;
    }
    public double getPrice(){
        return price;
    }
    public void setProductName(String productName){
        this.productName = productName;
    }
    public void setPrice(double price){
        this.price = price;
    }
    @Override
    public String toString(){
        return "Товар: " + productName + "\nЦена: " + price + "\n";
    }
}
