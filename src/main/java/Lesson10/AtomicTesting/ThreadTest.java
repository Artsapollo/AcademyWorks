package Lesson10.AtomicTesting;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadTest extends Thread {

    private AtomicInteger atomicInteger;
    private String name;

    public ThreadTest(AtomicInteger atomicInteger, String name) {
        this.atomicInteger = atomicInteger;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " waiting");
            for (int i = 0; i < 5; i++) {
                atomicInteger.incrementAndGet();
                System.out.println(this.name + ": " + atomicInteger.get());
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + " end of work");
    }

}