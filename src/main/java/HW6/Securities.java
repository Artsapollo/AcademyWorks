package HW6;

public class Securities implements Assets{
    private String name = "Securities";
    private int quantity;

    public Securities(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }
}
