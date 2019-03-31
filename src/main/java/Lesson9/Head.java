package Lesson9;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Head  {
    public static void main(String[] args) {
        Runnable task = () -> {
            Thread threadName = Thread.currentThread();
            System.out.println("Hello! " + threadName.getName());
        };
        new Thread(task).start();

        System.out.println("Done!");
List<String> list = new ArrayList<>();
        Collections.synchronizedCollection(list);

        IntCounter number = new IntCounter(0);
        Runnable task2 = () -> {
            for (int i = 0; i < 5000; i++) {
                number.increment();
            }
        };
        new Thread(task2).start();
        new Thread(task2).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Result: " + number.getCount());
    }

    private static class IntCounter {
        private int count;

        public IntCounter(int count) {
            this.count = count;
        }

        public int getCount() {
            return count;
        }

        public synchronized void increment() {
            count++;
        }
    }
}
