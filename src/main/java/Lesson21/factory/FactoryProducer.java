package Lesson21.factory;

import Lesson21.factory.firstSocksFactory.FirstSocksFactory;
import Lesson21.factory.premiumFactory.SecondSocksFactory;

public class FactoryProducer {
    public static FactoriesFactory getFactory(String input){
        if (("firstSocksFactory").equals(input)) {
            return new FirstSocksFactory();
        } else {
            return new SecondSocksFactory();
        }
    }
}
