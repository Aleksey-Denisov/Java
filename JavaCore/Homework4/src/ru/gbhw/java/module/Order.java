package ru.gbhw.java.module;

public class Order {
    private Buyer buyer;
    private Product product;
    private int quantity;
    
    public Order(Buyer buyer, Product product, int quantity){
        this.buyer = buyer;
        this.product = product;
        this.quantity = quantity;
    }
    public Buyer getBuyer(){
        return buyer;
    }
    public Product getProduct(){
        return product;
    }
    public int getQuantity(){
        return quantity;
    }
    public void setBuyer(Buyer buyer){
        this.buyer = buyer;
    }
    public void setProduct(Product product){
        this.product = product;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    @Override
    public String toString(){
        return String.format("%s %s %s", buyer, product, quantity);
    }
    
}
