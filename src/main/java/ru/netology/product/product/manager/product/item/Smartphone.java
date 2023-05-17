package ru.netology.product.product.manager.product.item;

public class Smartphone extends Product {

    private String brand;

    public Smartphone() {

    }

    public Smartphone(int id, String name, int price, String brand) {
        super(id, name, price);
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
