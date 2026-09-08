package org.skypro.skyshop.product;

public class BestResultNotFound extends Exception {

    public BestResultNotFound(String search) {
        super("Не найден подходящий результат для поиска: " + search);
    }
}
