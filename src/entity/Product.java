package entity;

import enums.Ram;
import enums.Screen;
import entity.Brand;
import helper.IdGenerator;

public abstract class Product {
    private static int objectCounter = 0;
    private final String id;
    private final String name;
    private final double discount;
    private int stock;
    private double price;
    private final Brand brand;
    private final Ram ram;
    private final Screen screenSize;

    public Product(String name,
                   double discount,
                   int stock,
                   double price,
                   Brand brand,
                   Ram ram,
                   Screen screenSize) {
        this.id = IdGenerator.generate(++objectCounter);
        this.name = name;
        this.discount = discount;
        this.stock = stock;
        this.price = price;
        this.brand = brand;
        this.ram = ram;
        this.screenSize = screenSize;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getDiscount() {
        return discount;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Brand getBrand() {
        return brand;
    }

    public Ram getRam() {
        return ram;
    }

    public double getScreenSize() {
        return Double.parseDouble(screenSize.toString());
    }

    @Override
    public String toString() {
        return "entity.Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", discount=" + discount +
                ", stock=" + stock +
                ", price=" + price +
                ", brand=" + brand +
                ", ram=" + ram +
                ", screenSize=" + screenSize +
                '}';
    }
}
