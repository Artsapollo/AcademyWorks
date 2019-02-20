package Lesson21.abstractFactory;

public class UaNissanImpl implements Nissan{
    public long getNissanPrice(){
        return 20000;
    }

    public String getText(){
        return "Nissan price in Ukraine: " + getNissanPrice();
    }

}
