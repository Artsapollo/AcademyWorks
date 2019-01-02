package HW6;

public class Gold implements Assets {
    private String name;
    private int quantity;


    public Gold(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String getName() {
        return "Gold";
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Asset" + " name = " + getName() + ", quantity = " + quantity ;
    }
}
