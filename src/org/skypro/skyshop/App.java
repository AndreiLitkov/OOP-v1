package org.skypro.skyshop;

import org.skypro.skyshop.articles.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.sql.SQLOutput;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {

        Product product1 = new SimpleProduct("Tuna", 150);
        Product product2 = new DiscountedProduct("Beef", 560, 15);
        Product product3 = new DiscountedProduct("Salad", 90, 10);
        Product product4 = new FixPriceProduct("Potato", 75);
        Product product5 = new SimpleProduct("Batat", 110);
        Product product6 = new FixPriceProduct("Chicken", 430);
        Product product7 = new SimpleProduct("Olive Oil", 520);
        Product product8 = new SimpleProduct("Mozarella", 270);

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
        System.out.println("==========================");
        System.out.println("Полиморфизм и интерфейсы проверка");

        SearchEngine searchEngine = new SearchEngine(10);
        FixPriceProduct coffee = new FixPriceProduct("Coffe", 200);
        SimpleProduct milk = new SimpleProduct("Milk", 100);
        DiscountedProduct cheese = new DiscountedProduct("Cheese", 100, 20);

        searchEngine.add(coffee);
        searchEngine.add(milk);
        searchEngine.add(cheese);

        Article article1 = new Article("Coffe", "Coffee - popular drink");
        Article article2 = new Article("Milk", "Milk has calcium");
        Article article3 = new Article("Cheese", "Cheese has different types");

        searchEngine.add(article1);
        searchEngine.add(article2);
        searchEngine.add(article3);

        Searchable[] result = searchEngine.search("Milk");
        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(searchEngine.search("Coffee")));
        System.out.println(Arrays.toString(searchEngine.search("Cheese")));
    }
}
