package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {


    public static int counterDiscount = 0;
    private int basicPrice;
    private int discountPercent;

    public DiscountedProduct(String name, int basicPrice, int discountPercent) {
        super(name);
        if (basicPrice <= 0) {
            throw new IllegalArgumentException("Базовая цена продукта должна быть больше 0");
        }
        if (discountPercent < 0 || discountPercent > 100) {
            throw new IllegalArgumentException("Скидка должна быть в диапазоне от 0 до 100");
        }
        this.basicPrice = basicPrice;
        this.discountPercent = discountPercent;
        counterDiscount++;
    }

    @Override
    public int getPrice() {
        int finalPrice = 0;
        finalPrice = basicPrice - (basicPrice * discountPercent / 100);
        return finalPrice;
    }

    public int getDiscount() {
        return discountPercent;
    }

    @Override
    public String toString() {
        return getName() + ": " + getPrice() + " (" + discountPercent + "%)";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
