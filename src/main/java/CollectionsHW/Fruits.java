package CollectionsHW;

import java.time.LocalDate;
import java.util.Objects;

public class Fruits implements FruitMood {
    private FruitsType type;
    private Integer expire;
    private LocalDate date;
    private Integer price;

    public Fruits(FruitsType type, int expire, LocalDate date, int price) {
        this.type = type;
        this.expire = expire;
        this.date = date;
        this.price = price;
    }

    @Override
    public FruitsType getType() {
        return type;
    }

    @Override
    public Integer getExpirationDays() {
        return expire;
    }

    @Override
    public LocalDate getDate() {
        return date;
    }

    @Override
    public Integer getPrice() {
        return price;
    }

    @Override
    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fruits)) return false;
        Fruits fruits = (Fruits) o;
        return expire == fruits.expire &&
                price == fruits.price &&
                getType() == fruits.getType() &&
                Objects.equals(getDate(), fruits.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), expire, getDate(), price);
    }

    @Override
    public String toString() {
        return "FruitsType = " + type + ", Expire = " + expire + ", Date = " + date + ", Price = " + price;
    }
}
