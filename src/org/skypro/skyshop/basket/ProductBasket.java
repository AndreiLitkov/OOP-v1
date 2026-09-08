package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ProductBasket {

    private final LinkedList<Product> products;

    public ProductBasket() {
        products = new LinkedList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }
    public List<Product> removeProductsByName(String name) {
        List<Product> removedProducts = new LinkedList<>();
        Iterator<Product> iterator = products.iterator();

        while (iterator.hasNext()) {
            Product product = iterator.next();

            if (product.getName().equals(name)) {
                removedProducts.add(product);
                iterator.remove();
            }
        }
        return removedProducts;
    }

    public int getTotalPrice() {
        int totalPrice = 0;

        for (Product product : products) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }

    public void printBasket() {
        boolean basketEmpty = true;
        int specialProductsCount = 0;

        for (Product product : products) {
            if (product != null) {
                System.out.println(product);
                basketEmpty = false;

                if (product.isSpecial()) {
                    specialProductsCount++;
                }
            }
        }

        if (basketEmpty) {
            System.out.println("В корзине пусто");
        }
        System.out.println("Итого: " + getTotalPrice());
        System.out.println("Специальных товаров: " + specialProductsCount);
    }
}
