package HW7;

import java.util.Comparator;

public class MyComparator implements Comparator<Fruit> {
    @Override
    public int compare(Fruit o1, Fruit o2) {
        int i = o1.getFruitType().toString().compareTo(o2.getFruitType().toString());
        int j = o1.getPrice() - o2.getPrice();
        if (i != 0){
            return i;
        }
        else {
            if (j != 0){
                return j;
            }
        }
        return i;
    }
}