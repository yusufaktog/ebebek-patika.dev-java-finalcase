package enums;

public enum Screen {
    PC_SMALL("13.3"),
    PC_MEDIUM("15.6"),
    PC_LARGE("17.3"),

    PHONE_SMALL("4.5"),
    PHONE_MEDIUM("5.2"),
    PHONE_LARGE("6.7")
    ;

    public final String size;

    Screen(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return size;
    }
}
