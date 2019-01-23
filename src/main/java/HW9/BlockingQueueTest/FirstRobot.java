package HW9.BlockingQueueTest;

import java.util.concurrent.BlockingQueue;

public class FirstRobot implements Runnable {

    private BlockingQueue example;

    public FirstRobot(BlockingQueue example) {
        this.example = example;
    }

    public void run() {
        try {
            for(int i = 1; i < 4; i++){
                example.put(i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
