package CollectionsHW;

import java.time.LocalDate;
import java.util.*;

public class Store {
    public static List<Fruits> listOfFruits() {
        List<Fruits> fruitList = new ArrayList<>();

        Fruits apple = new Fruits(FruitsType.APPLE, 20, LocalDate.of(2019, 1, 1), 15);
        Fruits straw = new Fruits(FruitsType.STRAWBERRY, 5, LocalDate.of(2018, 11, 3), 20);
        Fruits pear = new Fruits(FruitsType.PEAR, 19, LocalDate.of(2017, 10, 4), 40);
        Fruits pineapple = new Fruits(FruitsType.PINEAPPLE, 3, LocalDate.of(2018, 12, 1), 130);
        Fruits blueberry = new Fruits(FruitsType.BLUEBERRY, 7, LocalDate.of(2019, 1, 10), 900);
        Fruits dragon = new Fruits(FruitsType.DRAGONFRUIT, 90, LocalDate.of(2018, 10, 23), 1000);
        Fruits dragon1 = new Fruits(FruitsType.DRAGONFRUIT, 90, LocalDate.of(2018, 12, 16), 1200);
        Fruits dragon2 = new Fruits(FruitsType.DRAGONFRUIT, 90, LocalDate.of(2018, 8, 2), 800);

        fruitList.add(apple);
        fruitList.add(straw);
        fruitList.add(pear);
        fruitList.add(pineapple);
        fruitList.add(blueberry);
        fruitList.add(dragon);
        fruitList.add(dragon1);
        fruitList.add(dragon2);

        return fruitList;
    }

    public static void freshFruits(List<Fruits> list) {
        for (Fruits find : list) {
            if (find.getDate().isAfter(LocalDate.of(2018, 12, 12))) {
                System.out.println("The freshest " + find);
            }
        }
    }

    public static void fruitsType(List<Fruits> list) {
        for (Fruits find : list) {
            if (find.getType().equals(FruitsType.STRAWBERRY) || find.getType().equals(FruitsType.PINEAPPLE)) {
                System.out.println("Those Dragonfruit still good " + find);
            }
        }
    }

    public static void expireTime(List<Fruits> list) {
        for (Fruits find : list) {
            if (find.getExpire() > 10) {
                System.out.println("What about expiration " + find);
            }
        }
    }

    public static void stillFresh(List<Fruits> list) {
        for (Fruits find : list) {
            if (find.getType().equals(FruitsType.DRAGONFRUIT) && find.getDate().isAfter(LocalDate.of(2018, 10, 6))) {
                System.out.println("Those Dragonfruits still good " + find);
            }
        }
    }

    public static void letsDempThePrice(List<Fruits> list) {
        for (Fruits find : list) {
            if (find.getType().equals(FruitsType.STRAWBERRY) && find.getExpire() < 10
                    || find.getType().equals(FruitsType.PEAR) & find.getExpire() < 24) {
                find.setPrice(10);
                System.out.println("Reduced price " + find);
            }
        }
    }
}
