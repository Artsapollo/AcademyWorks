package lesson21.abstractFactory;

public class UaCarPrice implements InterAbsFactory {
    @Override
    public Porshe getPorshe() {
        return new UaPorsheImpl();
    }

    @Override
    public Audi getAudi() {
        return new UaAudiImpl();
    }

    @Override
    public Nissan getNissan() {
        return new UaNissanImpl();
    }

}
