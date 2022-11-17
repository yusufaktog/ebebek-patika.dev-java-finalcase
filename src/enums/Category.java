package enums;

public enum Category {
    NOTEBOOK("Notebook"),
    PHONE("Phone"),

    NONE("");

    public final String value;

    Category(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

}