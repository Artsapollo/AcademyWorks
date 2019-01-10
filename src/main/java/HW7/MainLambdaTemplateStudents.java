package HW7;

import java.io.*;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.*;

import static HW7.FruitType.*;
import static HW7.Vitamins.*;

public class MainLambdaTemplateStudents {
    public static void main(String[] args) {
        List<Fruit> fruits = fillFruitsList();
    //       fruits.forEach(System.out::println);

        //Unchecked Exception
        try {
            fruits.stream().map(fruit -> fruit.getPrice() + fruit.doingStupid(3)).forEach(System.out::println);
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
        System.out.println("-------------------------------------------------------");

        //Checked Exception
        try {
            Method method = fruits.getClass().getDeclaredMethod("fruitsTransportation");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        System.out.println("-------------------------------------------------------");

        //Deep cloning with serialization
        List<Fruit> cloneFruits = new ArrayList<>();
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream ous = new ObjectOutputStream(baos);

            ous.writeObject(fruits);
            ous.close();

            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);

            cloneFruits = (List) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        fruits.forEach(System.out::println);
        System.out.println();
        cloneFruits.forEach(System.out::println);

        System.out.println("-------------------------------------------------------");

/*
        fruits.stream().filter(fruit -> fruit.getFruitType().equals(PEAR))
                .forEach(System.out::println);
        System.out.println("-------------------------------------------------------");

        fruits.stream().skip(4).forEach(System.out::println);
        System.out.println("-------------------------------------------------------");

        fruits.stream().distinct().forEach(System.out::println);
        System.out.println("-------------------------------------------------------");

        fruits.stream().map(fruit -> fruit.getFruitType() + " " + fruit.getPrice())
                .forEach(System.out::println);
        System.out.println("-------------------------------------------------------");

        fruits.stream().map(Fruit::getTypeAndPrice)
                .forEach(System.out::println);
        System.out.println("-------------------------------------------------------");

        fruits.stream().peek(Fruit -> System.out.println("TAP"))
                .map(Fruit::getTypeAndPrice)
                .forEach(System.out::println);
        System.out.println("-------------------------------------------------------");

        fruits.stream().limit(4).forEach(System.out::println);
        System.out.println("-------------------------------------------------------");

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
        System.out.println("-------------------------------------------------------");

        fruits.stream().mapToInt(fruit -> fruit.getPrice())
                .forEach(System.out::println);
        System.out.println("-------------------------------------------------------");


        fruits.stream().flatMap(fruit -> fruit.getVitamins().stream())
                .forEach(System.out::println);
        System.out.println("-------------------------------------------------------");

        Optional<Fruit> opt = fruits.stream().findFirst();
        if (opt.isPresent()) {
            System.out.println(opt.get());
        } else {
            System.out.println("no value");
        }
        System.out.println("-------------------------------------------------------");

        Optional<Fruit> opt1 = fruits.stream().findAny();
        if (opt1.isPresent()) {
            System.out.println(opt1.get());
        } else {
            System.out.println("no value");
        }
        System.out.println("-------------------------------------------------------");

        long l = fruits.stream().count();
        System.out.println(l + " fruits in list");
        System.out.println("-------------------------------------------------------");

        boolean boom = fruits.stream().anyMatch(fruit -> fruit.getFruitType().equals(APPLE));
        System.out.println(boom);
        System.out.println("-------------------------------------------------------");

        boolean boom2 = fruits.stream().noneMatch(fruit -> fruit.getFruitType().equals("Banjo"));
        System.out.println(boom2);
        System.out.println("-------------------------------------------------------");

        boolean boom3 = fruits.stream()
                .allMatch(fruit -> fruit.getDayToLive() > 3);
        System.out.println(boom3);
        System.out.println("-------------------------------------------------------");

        Optional<Fruit> min = fruits.stream().min(Comparator.comparing(Fruit::getDayToLive));
        System.out.println(min);
        System.out.println("-------------------------------------------------------");

        Optional<Fruit> max = fruits.stream().max(Comparator.comparing(Fruit::getDayToLive));
        System.out.println(max);
        System.out.println("-------------------------------------------------------");

        fruits.stream().forEach(fruit -> System.out.println(fruit.getFruitType()));
        System.out.println("-------------------------------------------------------");

        fruits.stream().forEachOrdered(fruit -> System.out.println(fruit.getPrice()));
        System.out.println("-------------------------------------------------------");

        String[] arr = fruits.stream().map(Fruit::getTypeAndPrice).toArray(String[]::new);
        for (String far : arr) {
            System.out.println(far);
        }
        System.out.println("-------------------------------------------------------");

        int sum = fruits.stream().reduce(0, (x, y) -> {
                    if (y.getPrice() < 30)
                        return x + y.getPrice();
                    else
                        return x;
                },
                (x, y) -> x + y);
        System.out.println(sum);
        System.out.println("-------------------------------------------------------");
        */
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
