package hw9.SynchronizedBlock;

import java.util.ArrayList;
import java.util.List;

public class Australia {
    public static void main(String[] args) {
        Animal animal = new Animal();
        List<String> list = new ArrayList<>();
        animal.animalName("Chicko", list);
        System.out.println(animal.name);
    }
}
