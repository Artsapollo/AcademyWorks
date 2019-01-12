package HW9.SynchronizedMethod;

public class Counter {
    synchronized public void getCounter(){
        for(int i = 0; i < 5; i++){
            System.out.println(i);
            try{
                Thread.sleep(500);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
