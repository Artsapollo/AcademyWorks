package Lesson21.abstractFactory;

public class UaNissanImpl implements Nissan{
    @Override
    public long getNissanPrice(){
        return 20000;
    }

    @Override
    public String getText(){
        return "Nissan price in Ukraine: " + getNissanPrice();
    }

}
