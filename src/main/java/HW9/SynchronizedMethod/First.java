package HW9.SynchronizedMethod;

public class First {
    public static void main(String[] args) {
        Counter count = new Counter();

        Starter start1 = new Starter(count);
        Starter start2 = new Starter(count);

        start1.start();
        start2.start();
    }
}
//Зробить свої приклади використання сихронізованих методів, синхронізованих блоків
//
//приклади використання volatile