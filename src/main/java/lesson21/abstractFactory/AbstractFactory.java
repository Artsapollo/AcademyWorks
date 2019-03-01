package lesson21.abstractFactory;

public class AbstractFactory {
    public static void main(String[] args) {
        InterAbsFactory iaf = FactoryProducer.getFactory("UA");

        Porshe porshe = iaf.getPorshe();
        System.out.println(porshe.getText());

        Audi audi = iaf.getAudi();
        System.out.println(audi.getText());

        Nissan nissan = iaf.getNissan();
        System.out.println(nissan.getText());
    }
}
