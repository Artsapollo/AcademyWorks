package HW7;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static HW7.FruitType.*;
import static HW7.Vitamins.*;

public class MainLambdaTemplateStudents {
    public static void main(String[] args) {
        List<Fruit> fruits = fillFruitsList();
        //fruits.forEach(System.out::println);

        //fruits.stream().filter(fruit -> fruit.getFruitType().equals(PEAR))                                               //переменной fruit типа fruits заходим в список и методом get доступном для каждого из объектов, достаём нужный нам по параметру
        //      .forEach(System.out :: println);

        // fruits.stream().skip(4)
        //       .forEach(System.out :: println);

        //fruits.stream().distinct().forEach(System.out::println);

        //fruits.stream().map(fruit -> fruit.getFruitType()+" "+fruit.getPrice())
        //      .forEach(System.out :: println);

        // fruits.stream().map(Fruit :: getTypeAndPrice)
        //       .forEach(System.out :: println);

        //fruits.stream().peek(Fruit -> System.out.println("TAP"))
        //      .map(Fruit :: getTypeAndPrice)
        //   .forEach(System.out :: println);

        //fruits.stream().limit(4).forEach(System.out :: println);


        Comparator<Fruit> comparator = new Comparator<Fruit>() {
            @Override
            public int compare(Fruit o1, Fruit o2) {
                int r = o1.getFruitType().toString().compareTo(o2.getFruitType().toString());
                if (r != 0) {
                    return r;
                } else {
                    return o1.getPrice() - o2.getPrice();
                }
            }
        };
        fruits.stream().sorted(comparator).forEach(System.out::println);
    }

    private static List<Fruit> fillFruitsList() {
        List<Fruit> fruits = new ArrayList<>();

        Fruit fruit = new Fruit(APPLE, 30, LocalDate.of(2019, 1, 4), 12, null);
        fruit.setVitamins(Arrays.asList(new Vitamins[]{B, C}));
        fruits.add(fruit);

        fruit = new Fruit(STRAWBERRY, 15, LocalDate.of(2019, 1, 2), 50, null);
        fruit.setVitamins(Arrays.asList(new Vitamins[]{A, C}));
        fruits.add(fruit);

        fruit = new Fruit(PEAR, 30, LocalDate.of(2019, 1, 4), 40, null);
        fruit.setVitamins(Arrays.asList(new Vitamins[]{A, B1, B2, C}));
        fruits.add(fruit);

        fruit = new Fruit(ORANGE, 60, LocalDate.of(2019, 1, 3), 30, null);
        fruit.setVitamins(Arrays.asList(new Vitamins[]{E, B, A}));
        fruits.add(fruit);

        fruit = new Fruit(STRAWBERRY, 25, LocalDate.of(2019, 1, 2), 60, null);
        fruit.setVitamins(Arrays.asList(new Vitamins[]{A, C, D}));
        fruits.add(fruit);

        fruit = new Fruit(PEAR, 15, LocalDate.of(2019, 1, 4), 40, null);
        fruit.setVitamins(Arrays.asList(new Vitamins[]{A, B, B1, B2, P}));
        fruits.add(fruit);

        fruit = new Fruit(PEAR, 5, LocalDate.of(2019, 1, 6), 10, null);
        fruit.setVitamins(Arrays.asList(new Vitamins[]{B1, B2, P}));
        fruits.add(fruit);

        fruit = new Fruit(APPLE, 30, LocalDate.of(2019, 1, 4), 12, null);
        fruit.setVitamins(Arrays.asList(new Vitamins[]{B, C}));
        fruits.add(fruit);

        return fruits;
    }
}
