package HW6;

public class Gold implements Assets {
    private final String name = "Gold";
    private int quantity;


    public Gold(int quantity) {
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
