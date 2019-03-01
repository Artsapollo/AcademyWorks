package hw9.BlockingQueueTest;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ExampleQueue {
    public static void main(String[] args) {
        BlockingQueue queue = new ArrayBlockingQueue(3);

        FirstRobot robot1 = new FirstRobot(queue);
        SecondRobot robot2 = new SecondRobot(queue);

        new Thread(robot1).start();//Inserts strings with numbers into a BlockingQueue
        new Thread(robot2).start();//Taking them out on console

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
