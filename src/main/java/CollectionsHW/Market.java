package CollectionsHW;

import java.time.LocalDate;


public class Market extends Store {
    public static void main(String[] args) {

        Fruits apple = new Fruits(FruitsType.APPLE, 20, LocalDate.of(2019, 1, 1), 15);
        Fruits straw = new Fruits(FruitsType.STRAWBERRY, 5, LocalDate.of(2018, 11, 3), 20);
        Fruits pear = new Fruits(FruitsType.PEAR, 19, LocalDate.of(2017, 10, 4), 40);
        Fruits pine = new Fruits(FruitsType.PINEAPPLE, 3, LocalDate.of(2018, 12, 1), 130);
        Fruits blue = new Fruits(FruitsType.BLUEBERRY, 7, LocalDate.of(2019, 1, 10), 900);
        Fruits dragon = new Fruits(FruitsType.DRAGONFRUIT, 90, LocalDate.of(2018, 10, 23), 1000);
        Fruits dragon1 = new Fruits(FruitsType.DRAGONFRUIT, 90, LocalDate.of(2018, 12, 16), 1200);
        Fruits dragon2 = new Fruits(FruitsType.DRAGONFRUIT, 90, LocalDate.of(2018, 8, 2), 800);

        Store store = new Store(apple, straw, pear, pine, blue, dragon, dragon1, dragon2);

        store.freshFruits(LocalDate.of(2018, 12, 12));
        store.fruitsType(FruitsType.DRAGONFRUIT);
        store.expireTime(10);
        store.stillFresh(FruitsType.DRAGONFRUIT, LocalDate.of(2018, 10, 6));
        store.letsCutThePrice(FruitsType.PEAR, 24, 5.0);
    }
}
