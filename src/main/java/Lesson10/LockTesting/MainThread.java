package Lesson10.LockTesting;

import java.util.concurrent.locks.ReentrantLock;

public class MainThread {
    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();
        Resource resource = new Resource(0);

        new Thread(new ThreadTest(resource, lock, "Resource 1")).start();
        new Thread(new ThreadTest(resource, lock, "Resource 2")).start();
        new Thread(new ThreadTest(resource, lock, "Resource 3")).start();

    }
}
