public class Brand {
    private static int objectCounter = 0;
    private final String id;
    private final String name;

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
        return "Brand{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
