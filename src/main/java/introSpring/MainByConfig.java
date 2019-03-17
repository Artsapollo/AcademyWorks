package introSpring;

import introSpring.configPack.AppConfig;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainByConfig {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Cat cat = context.getBean(Cat.class);
        Dog dog = (Dog) context.getBean("dog");
        Mouse mouse = context.getBean("mouse", Mouse.class);
        AppConfig.Pig pig = context.getBean( AppConfig.Pig.class);
//        Animal animal = context.getBean(Animal.class);


        System.out.println(dog);
        System.out.println(cat);
        System.out.println(mouse);
//        System.out.println(animal);
        System.out.println(pig);

        context.close();
    }
}
