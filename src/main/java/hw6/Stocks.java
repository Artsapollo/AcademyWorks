package hw6;

public class Stocks implements Assets {
    private String name;
    private int quantity;

    public Stocks(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String getName() {
        return "Stocks";
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
