package Lesson21.abstractFactory;

public class RuAudiImpl implements Audi{
    public long getAudiPrice(){
        return 300000;
    }
    public String getText(){
        return "Audi price in Russian: " + getAudiPrice();
    }

}
