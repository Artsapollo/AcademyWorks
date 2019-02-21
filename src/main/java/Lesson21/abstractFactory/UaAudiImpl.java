package Lesson21.abstractFactory;

public class UaAudiImpl implements Audi {
    @Override
    public long getAudiPrice() {
        return 30000;
    }

    @Override
    public String getText() {
        return "Audi price in Ukraine: " + getAudiPrice();
    }

}
