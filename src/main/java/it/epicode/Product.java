package it.epicode;

import java.util.Random;

public class Product {
    private long id;
    private String name;
    private String category;
    private double price;

    public Product(String name, String category, double price) {
        Random rdnm = new Random();
        this.id = rdnm.nextLong(100000, 999999);
        this.name = name;
        this.category = category;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }

    public double sconto(double price) {
        double sconto = (price * 10) / 100;
        return price - sconto;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
