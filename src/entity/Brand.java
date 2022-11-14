package entity;

import helper.IdGenerator;

public class Brand {
     static int objectCounter = 0;
     final String id;
     final String name;

    public Brand(String name) {
        this.id = IdGenerator.generate(++objectCounter);
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "product.Brand{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
