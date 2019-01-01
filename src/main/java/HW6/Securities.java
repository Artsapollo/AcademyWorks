package HW6;

public class Securities implements Assets {
    private String name = "Securities";
    private int quantity;

    public Securities(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }
}
