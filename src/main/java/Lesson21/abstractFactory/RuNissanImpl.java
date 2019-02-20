package Lesson21.abstractFactory;

public class RuNissanImpl implements Nissan{
    public long getNissanPrice(){
        return 200000;
    }

    public String getText(){
        return "Nissan price in Russia: " + getNissanPrice();
    }

}
