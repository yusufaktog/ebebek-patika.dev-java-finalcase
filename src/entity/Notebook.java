package entity;

import enums.Ram;
import enums.Screen;
import enums.Storage;
import helper.IdGenerator;

public class Notebook extends Product {
    private static int counter = 0;
    private final Storage hdd;
    private final Storage ssd;

    public Notebook(String name,
                    double discount,
                    int stock,
                    double price,
                    Brand brand,
                    Ram ram,
                    Screen screenSize,
                    Storage hdd,
                    Storage ssd) {
        super(IdGenerator.generate(++counter, Notebook.class), name, discount, stock, price, brand, ram, screenSize);
        this.hdd = hdd;
        this.ssd = ssd;
    }

    public Storage getHdd() {
        return hdd;
    }

    public Storage getSsd() {
        return ssd;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " { " +
                "id = '" + super.getId() + '\'' +
                ", name = '" + super.getName() + '\'' +
                ", discount = " + super.getDiscount() +
                ", stock = " + super.getStock() +
                ", price = " + super.getPrice() +
                ", brand = " + super.getBrand().getName() +
                ", ram = " + super.getRam().toString() +
                ", screenSize = " + super.getScreenSize().toString() +
                ", hdd = " + hdd +
                ", ssd = " + ssd +
                '}';
    }
}
