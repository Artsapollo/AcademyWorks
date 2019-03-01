package lesson21.factory.firstSocksFactory;

import lesson21.factory.*;

public class FirstSocksFactory extends FactoriesFactory{
    @Override
    public Socks createSocks(String input) {
        Socks socks = null;
        if(("Need stripes").equals(input)){
            socks = new StripesSocks(13,"Blue", "Long stripe");
        } else if(("Going to space").equals(input)){
            socks = new SpaceSocks(12,"SpaceGrey", 909);
        } else if(("Going to prom").equals(input)){
            socks = new InvisibleSocks(9, "As you wish", 101);
        } else if (("I'm a man").equals(input)){
            socks = new MenSocks(15, "Darkest black", "Smells good");
        } else if (("I'm a princess").equals(input)){
            socks = new WomenSocks(7, "Beautiful sky", "Powerful");
        } else if (("Training is done").equals(input)){
            socks = new SweatSocks(11,"Dirty", "Yeeeah, it's sweater then you");
        }
        return socks;
    }
}
