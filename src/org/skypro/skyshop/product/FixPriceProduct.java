package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {

    private final int FIX_PRICE;
    public static int counterFix = 0;

    public FixPriceProduct(String name, int FIX_PRICE) {
        super(name);
        this.FIX_PRICE = FIX_PRICE;
        counterFix++;
    }

    @Override
    public int getPrice() {
        return FIX_PRICE;
    }

    @Override
    public String toString() {
        return getName() + ": Фиксированная цена " + FIX_PRICE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
