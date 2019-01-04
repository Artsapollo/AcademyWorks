package CollectionsHW;

import java.time.LocalDate;

public class Fruits {
    private Enum type;
    private int expire;
    private LocalDate date;
    private int price;

    public Enum getType() {
        return type;
    }

    public void setType(Enum type) {
        this.type = type;
    }

    public int getExpire() {
        return expire;
    }

    public void setExpire(int expire) {
        this.expire = expire;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "FruitsType = " + type + ", Expire = " + expire + ", Date = " + date + ", Price = " + price;
    }
}
