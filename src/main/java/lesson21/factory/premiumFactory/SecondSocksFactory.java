package lesson21.factory.premiumFactory;

import lesson21.factory.FactoriesFactory;
import lesson21.factory.Socks;

public class SecondSocksFactory extends FactoriesFactory {
      @Override
    public Socks createSocks(String input) {
        Socks socks = null;
        if (("Aunt Galya!").equals(input)) {
            socks = new PremiumAuntGalyaSocks(9, "Yellow", "With looove");
        } else if (("My dog is cold").equals(input)) {
            socks = new PremiumDogSocks(3, "Pink", "For American Stafford");
        } else if (("I need clean socks").equals(input)) {
            socks = new PremiumSweatSocks(13, "White", "But they are sweat");
        }
        return socks;
    }
}
