package Lesson10.ExecutorTesting;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainExecutor {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Resource resource = new Resource(0);

        executor.execute(new ThreadTest(resource,"Resource 1"));
        executor.execute(new ThreadTest(resource,"Resource 2"));
        executor.execute(new ThreadTest(resource,"Resource 3"));
        executor.shutdown();
    }
}
