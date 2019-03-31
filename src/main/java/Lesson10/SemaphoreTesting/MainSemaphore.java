package Lesson10.SemaphoreTesting;

import java.util.concurrent.Semaphore;

public class MainSemaphore {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        Resurs resurs = new Resurs(0);
        new Thread(new ThreadTest(resurs,semaphore,"Resource 1")).start();
        new Thread(new ThreadTest(resurs,semaphore,"Resource 2")).start();
        new Thread(new ThreadTest(resurs,semaphore,"Resource 3")).start();

    }
}
