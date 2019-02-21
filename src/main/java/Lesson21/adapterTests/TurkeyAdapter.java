package Lesson21.adapterTests;

public class TurkeyAdapter extends Duck{
    Turkey turkey;

    public TurkeyAdapter(Turkey turkey){
        this.turkey = turkey;
    }

    @Override
    public void quack(){
        turkey.gobble();
    }

    @Override
    public void fly(){
        turkey.fly();
    }
}
