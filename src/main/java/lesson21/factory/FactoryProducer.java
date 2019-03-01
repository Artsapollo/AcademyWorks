package lesson21.factory;

import lesson21.factory.firstSocksFactory.FirstSocksFactory;
import lesson21.factory.premiumFactory.SecondSocksFactory;

public class FactoryProducer {
    public static FactoriesFactory getFactory(String input){
        if (("firstSocksFactory").equals(input)) {
            return new FirstSocksFactory();
        } else {
            return new SecondSocksFactory();
        }
    }
}
