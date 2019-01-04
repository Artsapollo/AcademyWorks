package CollectionsHW;

import java.util.List;

public class Market extends Store {
    public static void main(String[] args) {
        List<Fruits> fruttis = listOfFruits();

        freshFruits(fruttis);
        System.out.println("-------------------------------------------------------------------------------------");
        fruitsType(fruttis);
        System.out.println("-------------------------------------------------------------------------------------");
        expireTime(fruttis);
        System.out.println("-------------------------------------------------------------------------------------");
        stillFresh(fruttis);
        System.out.println("-------------------------------------------------------------------------------------");
        letsDempThePrice(fruttis);
    }
}
