package Lesson10.ExecutorTesting;

public class ThreadTest extends Thread {

    private Resource resource;
    private String name;

    public ThreadTest(Resource resource, String name) {
        this.resource = resource;
        this.name = name;
    }

    @Override
    public void run() {
        try{
            System.out.println(name + " waiting");
            for(int i = 0; i < 5; i++){
                resource.increment();
                System.out.println(this.name + ": " + resource.getValue());
                Thread.sleep(100);
            }

        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(name + " end of work");
    }

}
