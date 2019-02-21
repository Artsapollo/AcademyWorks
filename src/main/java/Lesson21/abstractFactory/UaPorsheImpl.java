package Lesson21.abstractFactory;

public class UaPorsheImpl implements Porshe{
    @Override
    public long getPorshePrice(){
        return 40000;
    }

    @Override
    public String getText(){
        return "Porshe price in Ukraine: " + getPorshePrice();
    }

}
