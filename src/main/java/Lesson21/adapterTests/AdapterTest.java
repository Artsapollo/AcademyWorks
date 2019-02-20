package Lesson21.adapterTests;

public class AdapterTest {
    public static void main(String[] args) {
        Duck duck = new Duck();
        Turkey turkey = new Turkey();
        Duck turkeyAdapter = new TurkeyAdapter(turkey);

        System.out.println("Mr.Turkey says ");
        turkey.gobble();
        turkey.fly();

        System.out.println();

        System.out.println("Mr.Duck says ");
        testDuck(duck);

        System.out.println();

        System.out.println("Mr.Turkey Adapter says ");
        testDuck(turkeyAdapter);

    }
    static void testDuck(Duck duck){
        duck.quack();
        duck.fly();
    }

}