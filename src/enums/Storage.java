package enums;

public enum Storage {
    GB16("16GB"),

    GB32("32GB"),

    GB64("64GB"),

    GB128("128GB"),

    GB240("240GB"),

    GB256("256GB"),

    GB512("512GB"),

    TB1("1TB"),

    TB2("2TB"),

    TB3("3TB"),

    TB4("4TB"),

    TB5("5TB"),

    NONE("None");

    private final String storage;

    Storage(String storage) {
        this.storage = storage;
    }

    @Override
    public String toString() {
        return storage;
    }
}
