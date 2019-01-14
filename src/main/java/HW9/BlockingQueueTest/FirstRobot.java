package HW9.BlockingQueueTest;

import java.util.concurrent.BlockingQueue;

public class FirstRobot implements Runnable {

    private BlockingQueue example;

    public FirstRobot(BlockingQueue example) {
        this.example = example;
    }

    public void run() {
        try {
            example.put("1");
            Thread.sleep(1000);
            example.put("2");
            Thread.sleep(1000);
            example.put("3");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
