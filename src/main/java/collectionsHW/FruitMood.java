package collectionsHW;

import java.time.LocalDate;

public interface FruitMood {
    FruitsType getType();

    Integer getExpirationDays();

    LocalDate getDate();

    Integer getPrice();

    void setPrice(Integer price);
}
