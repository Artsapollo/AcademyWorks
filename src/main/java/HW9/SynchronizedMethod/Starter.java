package HW9.SynchronizedMethod;

public class Starter extends Thread {
    Counter counter;

    Starter(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        counter.getCounter();
    }
}
