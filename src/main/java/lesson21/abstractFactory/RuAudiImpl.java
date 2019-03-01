package lesson21.abstractFactory;

public class RuAudiImpl implements Audi {
    @Override
    public long getAudiPrice() {
        return 300000;
    }

    @Override
    public String getText() {
        return "Audi price in Russia: " + getAudiPrice();
    }

}
