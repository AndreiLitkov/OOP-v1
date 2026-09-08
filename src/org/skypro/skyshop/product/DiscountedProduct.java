package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {

    public static int counterDiscount = 0;
    private int basicPrice;
    private int discountPercent;

    public DiscountedProduct(String name, int basicPrice, int discountPercent) {
        super(name);
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
