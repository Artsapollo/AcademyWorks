package HW9.BlockingQueueTest;

import java.util.concurrent.BlockingQueue;

public class SecondRobot implements Runnable {

    protected BlockingQueue example;

    public SecondRobot(BlockingQueue example) {
        this.example = example;
    }

    public void run() {
        try {
            System.out.println(example.take());
            System.out.println(example.take());
            System.out.println(example.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
