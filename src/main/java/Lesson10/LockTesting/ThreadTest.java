package Lesson10.LockTesting;

import java.util.concurrent.locks.Lock;

public class ThreadTest extends Thread {

    private Resource resource;
    private Lock lock;
    private String name;

    public ThreadTest(Resource resource, Lock lock, String name) {
        this.resource = resource;
        this.lock = lock;
        this.name = name;
    }

    @Override
    public void run() {
        try{
            System.out.println(name + " waiting");
//            lock.lock();
            for(int i = 0; i < 5; i++){
                resource.increment();
                System.out.println(this.name + ": " + resource.getValue());
                Thread.sleep(100);
            }

        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(name + " end of work");
//        lock.unlock();
    }
}
