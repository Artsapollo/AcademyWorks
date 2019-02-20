package Lesson21.abstractFactory;

public class RuCarPrice implements InterAbsFactory{
    public Porshe getPorshe(){
        return new RuPorsheImpl();
    }

    public Audi getAudi(){
        return new RuAudiImpl();
    }

    public Nissan getNissan(){
        return new RuNissanImpl();
    }
}
