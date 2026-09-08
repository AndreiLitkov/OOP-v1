package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private final Product[] products;

    public ProductBasket() {
        this.products = new Product[5];
    }


    public void addProduct(Product product) {
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                products[i] = product;
                return;
            }
        }
        System.out.println("Невозможно добавить продукт");
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (Product product : products) {
            if (product != null) {
                totalPrice = totalPrice + product.getPrice();
            }
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

    public boolean hasProduct(String name) {
        boolean hasProduct = false;
        for (Product product1 : products) {
            if (product1 != null && product1.getName().equals(name)) {
                hasProduct = true;
                return hasProduct;
            }
        }
        return hasProduct;
    }

    public void clearBasket() {
        for (int i = 0; i < products.length; i++) {
            products[i] = null;
        }
    }
}
