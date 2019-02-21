package Lesson21.abstractFactory;

public class FactoryProducer {
    public static InterAbsFactory getFactory(String input) {
        if (("UA").equals(input)) {
            return new UaCarPrice();
        } else {
            return new RuCarPrice();
        }
    }
}
