package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {

        Product product1 = new Product("Tuna", 150);
        Product product2 = new Product("Beef", 560);
        Product product3 = new Product("Salad", 90);
        Product product4 = new Product("Potato", 75);
        Product product5 = new Product("Batat", 110);
        Product product6 = new Product("Chicken", 430);
        Product product7 = new Product("Olive Oil", 520);
        Product product8 = new Product("Mozarella", 270);

        ProductBasket basket1 = new ProductBasket();

        basket1.addProduct(product1);
        basket1.addProduct(product2);
        basket1.addProduct(product3);
        basket1.addProduct(product4);
        basket1.addProduct(product5);
        basket1.printBasket();

        System.out.println("Добавление продукта который не поместится в корзину");
        basket1.addProduct(product5);

        basket1.clearBasket();// очитска коризины
        System.out.println(" ");
        System.out.println("Содержимое корзины после очистки");
        basket1.printBasket();

        System.out.println(" ");
        basket1.addProduct(product2);
        basket1.addProduct(product8);
        basket1.addProduct(product6);

        System.out.println(" ");
        basket1.printBasket();

        System.out.println("Стоимость корзины продуктов = " + basket1.getTotalPrice());


        System.out.println(basket1.hasProduct("Batat"));
        System.out.println(basket1.hasProduct("Beef"));

        System.out.println(" ");
        basket1.clearBasket();
        basket1.printBasket();
        System.out.println(basket1.hasProduct("Beef"));
        System.out.println("Стоимость корзины продуктов = " + basket1.getTotalPrice());
    }

}
