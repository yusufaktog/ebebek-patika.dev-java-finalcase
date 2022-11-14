package entity;

import enums.Ram;
import enums.Screen;
import enums.Storage;

public class Notebook extends Product {
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
        super(name, discount, stock, price, brand, ram, screenSize);
        this.hdd = hdd;
        this.ssd = ssd;
    }

    public Storage getHdd() {
        return hdd;
    }

    public Storage getSsd() {
        return ssd;
    }
}
