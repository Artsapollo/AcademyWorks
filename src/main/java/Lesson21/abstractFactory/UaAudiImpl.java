package Lesson21.abstractFactory;

public class UaAudiImpl implements Audi{
    public long getAudiPrice(){
        return 30000;
    }
    public String getText(){
        return "Audi price in Ukraine: " + getAudiPrice();
    }

}
