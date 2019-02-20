package Lesson21.abstractFactory;

public class UaPorsheImpl implements Porshe{
    public long getPorshePrice(){
        return 40000;
    }

    public String getText(){
        return "Porshe price in Ukraine: " + getPorshePrice();
    }

}
