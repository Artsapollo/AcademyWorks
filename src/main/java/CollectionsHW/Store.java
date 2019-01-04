package CollectionsHW;

import java.time.LocalDate;
import java.util.*;

public class Store {
    private List<Fruits> fruitsList;

    public Store(Fruits... fruits) {
        fruitsList = Arrays.asList(fruits);
    }

    public void freshFruits(LocalDate date) {
        List<Fruits> list = new ArrayList<>();
        for (Fruits find : fruitsList) {
            if (find.getDate().isAfter(date)) {
                list.add(find);
            }
        }

        System.out.println("The Freshest " + list.toString());
    }

    public void fruitsType(FruitsType type) {
        List<Fruits> list = new ArrayList<>();
        for (Fruits find : fruitsList) {
            if (find.getType().equals(type)) {
                list.add(find);
            }
        }
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("Yummy " + list.toString());
    }

    public List<Fruits> expireTime(Integer expire) {
        List<Fruits> list = new ArrayList<>();
        for (Fruits find : fruitsList) {
            if (find.getExpirationDays() > expire) {
                list.add(find);
            }
        }
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("What about expiration " + list.toString());
        return list;
    }

    public List<Fruits> stillFresh(FruitsType type, LocalDate date) {
        List<Fruits> list = new ArrayList<>();
        for (Fruits find : fruitsList) {
            if (find.getType().equals(type) && find.getDate().isAfter(date)) {
                list.add(find);
            }
        }
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("Those are still good " + list.toString());
        return list;
    }

    public List<Fruits> letsCutThePrice(FruitsType type, Integer expire, Double discount) {
        List<Fruits> list = new ArrayList<>();
        for (Fruits find : fruitsList) {
            if (find.getType().equals(type) && find.getExpirationDays() < expire) {
                find.setPrice((int) (find.getPrice() * discount));
                list.add(find);
            }
        }
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("Reducing price " + list.toString());
        return list;
    }
}