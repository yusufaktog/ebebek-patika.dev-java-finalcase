package enums;

public enum Color {

    YELLOW("YELLOW"),

    RED("RED"),

    GREEN("GREEN"),

    BLUE("BLUE"),

    GRAY("GRAY"),

    CYAN("CYAN"),

    BLACK("BLACK"),

    PURPLE("PURPLE"),

    MAGENTA("MAGENTA");
    public final String color;

    Color(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return color;
    }
}
