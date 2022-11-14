import enums.Ram;
import enums.Screen;
import enums.Storage;

public class Phone extends Product {
    private final String color;
    private final int battery;
    private final Storage storage;

    public Phone(String name,
                 double discount,
                 int stock,
                 double price,
                 Brand brand,
                 Ram ram,
                 Screen screenSize,
                 String color,
                 int battery,
                 Storage storage
    ) {
        super(name, discount, stock, price, brand, ram, screenSize);
        this.color = color;
        this.battery = battery;
        this.storage = storage;
    }

    public String getColor() {
        return color;
    }

    public int getBattery() {
        return battery;
    }

    public Storage getStorage() {
        return storage;
    }
}