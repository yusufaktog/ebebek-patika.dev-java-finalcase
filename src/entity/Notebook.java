package entity;

import enums.Ram;
import enums.Screen;
import enums.Storage;
import helper.IdGenerator;

public class Notebook extends Product {
    private static int counter = 0;
    private final Storage hdd;
    private final Storage ssd;
    private final Ram ram;
    private final Screen screen;

    public Notebook(String name,
                    double discount,
                    int stock,
                    double price,
                    Brand brand,
                    Ram ram,
                    Screen screen,
                    Storage hdd,
                    Storage ssd) {
        super(IdGenerator.generate(++counter, Notebook.class), name, discount, stock, price, brand);
        this.hdd = hdd;
        this.ssd = ssd;
        this.ram = ram;
        this.screen = screen;
    }

    public Storage getHdd() {
        return hdd;
    }

    public Storage getSsd() {
        return ssd;
    }

    public Ram getRam() {
        return ram;
    }
    public Screen getScreen() {
        return screen;
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
                ", ram = " + ram.toString() +
                ", screenSize = " + screen.toString() +
                ", hdd = " + hdd +
                ", ssd = " + ssd +
                '}';
    }
}
