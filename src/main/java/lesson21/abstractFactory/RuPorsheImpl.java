package lesson21.abstractFactory;

public class RuPorsheImpl implements Porshe{
    @Override
    public long getPorshePrice(){
        return 400000;
    }

    @Override
    public String getText(){
        return "Porshe price in Russia: " + getPorshePrice();
    }

}
