package ru.gbhw.java.controller;

import ru.gbhw.java.module.Buyer;
import ru.gbhw.java.module.Order;
import ru.gbhw.java.module.Product;

public class ShopController {
    private Buyer[] buyers;
    private Product[] products;
    private Order[] orders;

    public ShopController() throws CustomerException{
         buyers = new Buyer[]{
            new Buyer("Иванов Иван Иваночич",34,"+79510515465"),
            new Buyer("Петров Петр Петрович",25,"+79565445255")
        };
        products = new Product[]{
            new Product("Йогурт", 50),
            new Product("Хлеб", 30),
            new Product("Бананы", 99),
            new Product("Курица", 150),
            new Product("Рыба", 200)
        };
        orders = new Order[5];
        orders[0] = ShopController.makeAPurchase(buyers, products, "Иванов Иван Иваночич", "Хлеб", 2);
        orders[1] = ShopController.makeAPurchase(buyers, products, "Васильев Федор Валентиновчи", "Рыба", 2);
        orders[2] = ShopController.makeAPurchase(buyers, products, "Петров Петр Петрович", "Ананас", 10);
        orders[3] = ShopController.makeAPurchase(buyers, products, "Петров Петр Петрович", "Йогурт", 105);
        orders[4] = ShopController.makeAPurchase(buyers, products, "Иванов Иван Иваночич", "Бананы", 10);

        for(Order order : orders){
            System.out.println(order);
        }
    }
    private static Order makeAPurchase(Buyer[] buyers, Product[] products, String fio, String productName, int quantity) throws CustomerException{
        Order order = null;
        Buyer buyer = null;
        Product product = null;
        try{
            for(Product temp : products){
                if(temp.getProductName().equals(productName))
                    product = temp;
            }
            if(product == null)
                throw new ProductException();
            try{
                if(quantity <= 0 || quantity >= 100)
                    throw new AmountException();
            }catch (AmountException ex) {
                System.out.println(ex);
                quantity = 1;
            }
            for(Buyer temp : buyers){
                if(temp.getFio().equals(fio))
                    buyer = temp;
                }
            if(buyer == null)
                throw new CustomerException();
            order = new Order(buyer, product, quantity);
        }catch(ProductException ex){
            System.out.println(ex);
        }
        return order;
    }
}
