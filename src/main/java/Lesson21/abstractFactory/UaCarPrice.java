package Lesson21.abstractFactory;

public class UaCarPrice implements InterAbsFactory{
    public Porshe getPorshe(){
        return new UaPorsheImpl();
    }
    public Audi getAudi(){
        return new UaAudiImpl();
    }
    public Nissan getNissan(){
        return new UaNissanImpl();
    }

}
