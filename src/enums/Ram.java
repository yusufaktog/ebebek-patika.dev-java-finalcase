package enums;

public enum Ram {
    MB128("128MB"),

    MB256("256MB"),

    MB512("512MB"),

    GB1("1GB"),

    GB2("2GB"),

    GB3("3GB"),

    GB4("4GB"),

    GB6("6GB"),

    GB8("8GB"),

    GB16("16GB"),

    GB32("32GB"),

    GB48("48GB"),

    GB64("64GB"),

    GB128("128GB")
    ;
    private final String ram;

    Ram(String ram) {
        this.ram = ram;
    }

    @Override
    public String toString() {
        return ram;
    }
}

