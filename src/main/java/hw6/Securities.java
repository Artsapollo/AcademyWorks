package hw6;

public class Securities implements Assets {
    private String name;
    private int quantity;

    public Securities(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String getName() {
        return "Securities";
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Asset" + " name = " + getName() + ", quantity = " + quantity;
    }
}
