package Lesson21;

public class SingletonTest {
    private static SingletonTest instance = null;

    private SingletonTest() {
    }

    public static  SingletonTest getInstance() {
        if (instance == null) {
            synchronized (SingletonTest.class){
                if(instance == null ){
                    instance = new SingletonTest();
                }
            }
        }
        return instance;
    }

    public void setUp() {
        System.out.println("setUp");
    }
}
