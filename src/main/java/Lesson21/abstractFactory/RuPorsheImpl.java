package Lesson21.abstractFactory;

public class RuPorsheImpl implements Porshe{
    public long getPorshePrice(){
        return 400000;
    }

    public String getText(){
        return "Porshe price in Russia: " + getPorshePrice();
    }

}
