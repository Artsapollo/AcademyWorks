package HW6;

public class Stocks implements Assets{
    private String name = "Stocks";
    private int quantity;

    public Stocks(int quantity){
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }
}
