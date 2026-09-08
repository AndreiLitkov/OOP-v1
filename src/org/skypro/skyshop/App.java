package org.skypro.skyshop;

import org.skypro.skyshop.articles.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;

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

        //basket1.clearBasket();// очитска коризины
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


//        System.out.println(basket1.hasProduct("Batat"));
//        System.out.println(basket1.hasProduct("Beef"));

        System.out.println(" ");
//        basket1.clearBasket();
        basket1.printBasket();
//        System.out.println(basket1.hasProduct("Beef"));
        System.out.println("Стоимость корзины продуктов = " + basket1.getTotalPrice());

        System.out.println("==========================");
        System.out.println("Полиморфизм и интерфейсы проверка");

        SearchEngine searchEngine = new SearchEngine();
        FixPriceProduct coffee = new FixPriceProduct("Coffe", 200);
        SimpleProduct milk = new SimpleProduct("Milk", 100);
        DiscountedProduct cheese = new DiscountedProduct("Cheese", 100, 20);

        searchEngine.add(coffee);
        searchEngine.add(milk);
        searchEngine.add(cheese);

        Article article1 = new Article("Coffe", "Coffee - popular drink");
        Article article2 = new Article("Milk", "Milk has calcium");
        Article article3 = new Article("Cheese", "Cheese has different types");

//        searchEngine.add(article1);
//        searchEngine.add(article2);
//        searchEngine.add(article3);
//
//        System.out.println(Arrays.toString(searchEngine.search("Coffee")));
//        System.out.println(Arrays.toString(searchEngine.search("Cheese")));
//
//        Searchable[] result = searchEngine.search("Milk");
//        System.out.println(Arrays.toString(result));
//        for (Searchable searchable : result) {
//            if (searchable != null) {
//                System.out.println(searchable.getStringRepresentation());
//            }
//
//        }

        System.out.println("======================");
        System.out.println("Исключения");

        try {
            SimpleProduct product10 =
                    new SimpleProduct("", 100);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            SimpleProduct product11 =
                    new SimpleProduct("Молоко", 0);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            DiscountedProduct product12 =
                    new DiscountedProduct("Хлеб", 0, 20);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            DiscountedProduct product13 =
                    new DiscountedProduct("Сыр", 100, 101);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            DiscountedProduct product14 =
                    new DiscountedProduct("Масло", 100, -10);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            FixPriceProduct product15 =
                    new FixPriceProduct(null, 100);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        SimpleProduct milk1 = new SimpleProduct("Молоко", 100);
        DiscountedProduct bread = new DiscountedProduct("Хлеб", 80, 20);
        FixPriceProduct coffee1 = new FixPriceProduct("Кофе", 150);

        Article article10 = new Article("Молоко", "Молоко полезно. Молоко содержит кальций.");
        Article article11 = new Article("Кофе","Кофе является популярным напитком.");
        Article article12 = new Article("Хлеб", "Хлеб — важный продукт.");

        SearchEngine searchEngine1 = new SearchEngine();
        searchEngine1.add(milk1);
        searchEngine1.add(bread);
        searchEngine1.add(coffee1);

        searchEngine1.add(article10);
        searchEngine1.add(article11);
        searchEngine1.add(article12);

        try {
            Searchable result1 = searchEngine1.findBestMatch("Молоко");
            System.out.println(result1.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }
        try {
            Searchable result1 = searchEngine1.findBestMatch("Самолёт");
            System.out.println(result1.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }

        System.out.println("===============");
        System.out.println("Java Collections Framework: List");

        ProductBasket productBasket2 = new ProductBasket();
        productBasket2.addProduct(milk1);
        productBasket2.addProduct(bread);
        productBasket2.addProduct(coffee1);

        System.out.println("Удаляем Молоко:");

        List<Product> removedProducts = productBasket2.removeProductsByName("Молоко");
        for (Product product : removedProducts) {
            System.out.println(product);
        }
        productBasket2.printBasket();

        System.out.println("Удаляем Самолёт:");

        List<Product> removedProducts2 = productBasket2.removeProductsByName("Самолёт");

        if (removedProducts2.isEmpty()) {
            System.out.println("Список пуст");
        } else {
            for (Product product : removedProducts2) {
                System.out.println(product);
            }
        }
        productBasket2.printBasket();

        List<Searchable> results = searchEngine1.search("Хлеб");
        for (Searchable result : results) {
            System.out.println(result.getStringRepresentation());
        }

    }
}
