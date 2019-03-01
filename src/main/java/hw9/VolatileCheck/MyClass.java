package hw9.VolatileCheck;

import java.io.*;

public class MyClass {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        myThread.shutdown();
    }
}
