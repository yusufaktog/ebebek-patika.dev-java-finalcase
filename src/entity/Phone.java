package entity;

import enums.Color;
import enums.Ram;
import enums.Screen;
import enums.Storage;
import helper.IdGenerator;

public class Phone extends Product {
    private static int counter = 0;
    private final Color color;
    private final int battery;
    private final Storage storage;

    private final Ram ram;
    private final Screen screenSize;

    public Phone(String name,
                 double discount,
                 int stock,
                 double price,
                 Brand brand,
                 Ram ram,
                 Screen screenSize,
                 Color color,
                 int battery,
                 Storage storage
    ) {

        super(IdGenerator.generate(++counter, Phone.class), name, discount, stock, price, brand);
        this.color = color;
        this.battery = battery;
        this.storage = storage;
        this.ram = ram;
        this.screenSize = screenSize;
    }

    public Ram getRam() {
        return ram;
    }

    public Screen getScreenSize() {
        return screenSize;
    }

    public Color getColor() {
        return color;
    }

    public int getBattery() {
        return battery;
    }

    public Storage getStorage() {
        return storage;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{ " +
                "id = '" + super.getId() + '\'' +
                ", name = '" + super.getName() + '\'' +
                ", discount = " + super.getDiscount() +
                ", stock = " + super.getStock() +
                ", price = " + super.getPrice() +
                ", brand = " + super.getBrand().getName() +
                ", ram = " + ram.toString() +
                ", screenSize = " + screenSize.toString() +
                ", color = " + color +
                ", battery = " + battery +
                ", storage = " + storage +
                " }";
    }
}