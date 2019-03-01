package hw7;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.*;

import static hw7.Vitamins.*;
import static hw7.FruitType.*;


public class MainLambdaTemplateStudents {
    public static void main(String[] args) {
        List<Fruit> fruits = fillFruitsList();
        fruits.forEach(System.out::println);

        System.out.println("Conveyor methods");
        System.out.println("filter");
        fruits.stream().filter(fruit -> FruitType.PEAR.equals(fruit.getFruitType())).forEach(System.out::println);

        System.out.println("skip 4 first");
        fruits.stream().skip(4).forEach(System.out::println);

        System.out.println("distinct");
        fruits.stream().distinct().forEach(System.out::println);

        System.out.println("map");
        fruits.stream().map(s -> s.getFruitType() + " " + s.getPrice()).forEach(System.out::println);
        System.out.println("map2");
        fruits.stream().map(s -> {return s.getPrice() + " " + s.getFruitType();}).forEach(System.out::println);
        System.out.println("map3");
        fruits.stream().map(Fruit::getFruitType).forEach(System.out::println);
        System.out.println("map4");
        fruits.stream().map(Fruit::getTypeAndPrice).forEach(System.out::println);

        System.out.println("peek");
        fruits.stream().peek(p -> System.out.println("peek peek" + p)).map(Fruit::getTypeAndPrice).forEach(System.out::println);

        System.out.println("limit");
        fruits.stream().limit(4).forEach(System.out::println);

        System.out.println("sorted");
        fruits.stream().sorted(new MyComparator()).forEach(System.out::println);

        System.out.println("mapToInt");
        fruits.stream().mapToInt(Fruit::getPrice).forEach(System.out::println);

        System.out.println("flatMapToInt");
        fruits.stream().flatMapToInt(m -> IntStream.of(m.getPrice())).forEach(System.out::println);

        System.out.println("Terminal methods_________");
        System.out.println("findFirst");
        System.out.println(fruits.stream().findFirst().orElse(new Fruit(FruitType.APPLE, 30, LocalDate.of(2019,1,4), 12, null)));

        System.out.println("findAny");
        System.out.println(fruits.stream().findAny().orElseThrow(RuntimeException::new));

        System.out.println("collect");
        System.out.println(fruits.stream().sorted(new MyComparator()).collect(Collectors.toList()));

        System.out.println("count");
        System.out.println(fruits.stream().filter(s -> FruitType.APPLE.equals(s.getFruitType())).count());

        System.out.println("anyMatch");
        System.out.println(fruits.stream().anyMatch(s -> FruitType.ORANGE.equals(s.getFruitType())));

        System.out.println("noneMatch");
        System.out.println(fruits.stream().noneMatch(new Object()::equals));

        System.out.println("allMatch");
        System.out.println(fruits.stream().allMatch(s -> s.getVitamins().equals(null)));

        System.out.println("min");
        System.out.println(fruits.stream().min(new MyComparator()));

        System.out.println("max");
        System.out.println(fruits.stream().max(new MyComparator()));

        System.out.println("forEach");
        fruits.stream().forEach(s -> s.setPrice(s.getPrice() * 2));
        System.out.println(fruits.toString());

        System.out.println("forEachOrdered");
        fruits.stream().forEachOrdered(s -> s.setPrice(s.getPrice() / 2));
        System.out.println(fruits.toString());

        System.out.println("toArray");
        FruitType[] fruitTypeArr = fruits.stream().map(Fruit::getFruitType).toArray(FruitType[]::new);
        for (FruitType i : fruitTypeArr){
            System.out.println(i);
        }

        System.out.println("reduce");
        System.out.println(fruits.stream().map(Fruit::getPrice).reduce(0, (s1, s2) -> s1 + s2));
    }

    private static List<Fruit> fillFruitsList() {
        List<Fruit> fruits = new ArrayList<>();

        Fruit fruit = new Fruit(APPLE, 30, LocalDate.of(2019, 1, 4), 12, null);
        fruit.setVitamins(Arrays.asList(new Vitamins[] { B, C }));
        fruits.add(fruit);

        fruit = new Fruit(STRAWBERRY, 15, LocalDate.of(2019, 1, 2), 50, null);
        fruit.setVitamins(Arrays.asList(new Vitamins[] { A, C }));
        fruits.add(fruit);

        fruit = new Fruit(PEAR, 30, LocalDate.of(2019, 1, 4), 40, null);
        fruit.setVitamins(Arrays.asList(new Vitamins[] { A, B1, B2, C }));
        fruits.add(fruit);

        fruit = new Fruit(ORANGE, 60, LocalDate.of(2019, 1, 3), 30, null);
        fruit.setVitamins(Arrays.asList(new Vitamins[] { E, B, A }));
        fruits.add(fruit);

        fruit = new Fruit(STRAWBERRY, 25, LocalDate.of(2019, 1, 2), 60, null);
        fruit.setVitamins(Arrays.asList(new Vitamins[] { A, C, D }));
        fruits.add(fruit);

        fruit = new Fruit(PEAR, 15, LocalDate.of(2019, 1, 4), 40, null);
        fruit.setVitamins(Arrays.asList(new Vitamins[] { A, B, B1, B2, P }));
        fruits.add(fruit);

        fruit = new Fruit(PEAR, 5, LocalDate.of(2019, 1, 6), 10, null);
        fruit.setVitamins(Arrays.asList(new Vitamins[] { B1, B2, P }));
        fruits.add(fruit);

        fruit = new Fruit(APPLE, 30, LocalDate.of(2019, 1, 4), 12, null);
        fruit.setVitamins(Arrays.asList(new Vitamins[] { B, C }));
        fruits.add(fruit);

        return fruits;
    }
}