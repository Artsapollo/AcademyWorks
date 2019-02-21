package Lesson21.abstractFactory;

public class RuCarPrice implements InterAbsFactory{
    @Override
    public Porshe getPorshe(){
        return new RuPorsheImpl();
    }

    @Override
    public Audi getAudi(){
        return new RuAudiImpl();
    }

    @Override
    public Nissan getNissan(){
        return new RuNissanImpl();
    }
}
