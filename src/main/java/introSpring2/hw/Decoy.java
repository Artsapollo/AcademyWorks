package introSpring2.hw;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Lazy
public class Decoy {
    private String name;
    private String tag;

    public Decoy(@Value("No name")String name, @Value("9/06")String tag) {
        this.name = name;
        this.tag = tag;
        System.out.println("Decoy");
    }

    @PostConstruct
    public void init(){
        name = this.getClass().getSimpleName();
        System.out.println("From init method " + this);
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("From preDestroy method " + this + " Mayor Sung knew");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "Name: " + getName() + " Tag: " + getTag();
    }
}
