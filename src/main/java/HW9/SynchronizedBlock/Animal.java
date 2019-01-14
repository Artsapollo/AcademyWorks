package HW9.SynchronizedBlock;

import java.util.List;

public class Animal {
    String name = " ";
    public int count = 0;

    public void animalName(String wallaby, List<String> list) {
        synchronized (Animal.class) {
            name = wallaby;
            count++;
        }
        list.add(wallaby);
    }
}
