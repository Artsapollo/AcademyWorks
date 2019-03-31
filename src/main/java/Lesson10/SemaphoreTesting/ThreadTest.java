package Lesson10.SemaphoreTesting;

import java.util.concurrent.Semaphore;

public class ThreadTest extends Thread {

    private Resurs resource;
    private Semaphore semaphore;
    private String name;

    public ThreadTest(Resurs resource, Semaphore sem, String name) {
        this.resource = resource;
        this.semaphore = sem;
        this.name = name;
    }

    @Override
    public void run() {
        try{
            System.out.println(name + " waiting");
            semaphore.acquire();
            for(int i = 0; i < 5; i++){
                resource.increment();
                System.out.println(this.name + ": " + resource.getValue());
                Thread.sleep(100);
            }

        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(name + " end of work");
        semaphore.release();
    }
}
