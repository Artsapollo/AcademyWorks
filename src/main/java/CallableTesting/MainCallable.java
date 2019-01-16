package CallableTesting;

import java.util.concurrent.*;

public class MainCallable {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Resource resource = new Resource(0);

        Callable<String> callable1 = new ThreadTest(resource, "Thread1");
        Callable<String> callable2 = new ThreadTest(resource, "Thread2");
        Callable<String> callable3 = new ThreadTest(resource, "Thread3");


        Future<String> future = executorService.submit(callable1);
        Future<String> future2 = executorService.submit(callable2);
        Future<String> future3 = executorService.submit(callable3);

        try {
            future.get();
            future2.get();
            future3.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }
}
