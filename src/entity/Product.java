package entity;

public abstract class Product {
    private final String id;
    private final String name;
    private final double discount;
    private int stock;
    private double price;
    private final Brand brand;


    public Product(String id,
                   String name,
                   double discount,
                   int stock,
                   double price,
                   Brand brand
    ) {
        this.id = id;
        this.name = name;
        this.discount = discount;
        this.stock = stock;
        this.price = price;
        this.brand = brand;
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


    @Override
    public String toString() {
        return "Product {" +
                "id = '" + id + '\'' +
                ", name = '" + name + '\'' +
                ", discount = " + discount +
                ", stock = " + stock +
                ", price = " + price +
                ", brand = " + brand.getName() +
                '}';
    }
}