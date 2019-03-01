package hw9.BlockingQueueTest;

import java.util.concurrent.BlockingQueue;

public class SecondRobot implements Runnable {

    private BlockingQueue example;

    public SecondRobot(BlockingQueue example) {
        this.example = example;
    }

    public void run() {
        try {
            for(int i = 0; i < 3; i++) {
                System.out.println(example.take());
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
