package Lesson21.adapterTests;

public class TurkeyAdapter extends Duck{
    Turkey turkey;

    public TurkeyAdapter(Turkey turkey){
        this.turkey = turkey;
    }

    public void quack(){
        turkey.gobble();
    }

    public void fly(){
        turkey.fly();
    }
}
