package HW6;

public class Stocks implements Assets {
    private String name = "Stocks";
    private int quantity;

    public Stocks(int quantity) {
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
