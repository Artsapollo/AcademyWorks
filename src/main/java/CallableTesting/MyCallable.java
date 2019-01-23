package CallableTesting;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {

    private Resource resource;
    private String name;

    public MyCallable(Resource resource, String name) {
        this.resource = resource;
        this.name = name;
    }

    @Override
    public String call() throws InterruptedException{
        System.out.println(name + " waiting");
        for(int i = 0; i < 5; i++){
            resource.increment();
            System.out.println(this.name + ": " + resource.getValue());
            Thread.sleep(500);
        }
        return name + " end of work";
    }
}
