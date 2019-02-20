package Lesson21.factory;

public class MainSocks {
    public static void main(String[] args){
        FactoriesFactory factoriesFactory = FactoryProducer.getFactory("Jitomur");
        Socks socks = factoriesFactory.createSocks("Aunt Galya!");
        System.out.println(socks);


//        printSocks("Need stripes");
//        printSocks("Going to space");
//        printSocks("Going to prom");
//        printSocks("I'm a man");
//        printSocks("I'm a princess");
//        printSocks("Training is done");
    }
}