package Lesson10;

public class SingletonTest {

    //First method
//    private static final SingletonTest instance = new SingletonTest();
//
//    private SingletonTest() {
//
//    }
//
//    public static SingletonTest getInstance() {
//        return instance;
//    }

    //Second method
//    private static SingletonTest instance;
//
//    private SingletonTest() {
//
//    }
//
//    public static SingletonTest getInstance() {
//        if (instance == null) {
//            instance = new SingletonTest();
//        }
//        return instance;
//    }

    //Third method
//    private static SingletonTest instance;
//
//    private SingletonTest() {
//
//    }
//
//    public static synchronized SingletonTest getInstance() {
//        if (instance == null) {
//            instance = new SingletonTest();
//        }
//        return instance;
//    }

    //Fours method
    private static SingletonTest instance;
    private SingletonTest(){

    }

    public static SingletonTest getInstance(){
        if(instance == null){
            synchronized (SingletonTest.class){
                if (instance == null){
                    instance = new SingletonTest();
                }
            }
        }
        return instance;
    }
}
