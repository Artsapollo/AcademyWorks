package Lesson10.AtomicTesting;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class MainAtomic {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        AtomicInteger atomicInteger = new AtomicInteger(3);

        executor.execute(new ThreadTest(atomicInteger,"Resource 1"));
        executor.execute(new ThreadTest(atomicInteger,"Resource 2"));
        executor.execute(new ThreadTest(atomicInteger,"Resource 3"));
        executor.shutdown();
    }
}
