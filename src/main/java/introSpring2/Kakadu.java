package introSpring2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Lazy
public class Kakadu {
    private String name;
    private int weight;

    public Kakadu(@Value("DefaultName") String name, @Value("1") int weight) {
        this.name = name;
        this.weight = weight;
        System.out.println("Kakadu");
    }

    @PostConstruct
    public void init(){
        name = this.getClass().getSimpleName();
        System.out.println("In init method " + this);
    }

    @PreDestroy
    private void preDestroy(){
        System.out.println("In preDestroy method. "+ this + " will be die");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Kakadu " + " name " + getName() + " weight " + getWeight();
    }
}
