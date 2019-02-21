package Lesson21.abstractFactory;

public class RuNissanImpl implements Nissan{
    @Override
    public long getNissanPrice(){
        return 200000;
    }

    @Override
    public String getText(){
        return "Nissan price in Russia: " + getNissanPrice();
    }

}
