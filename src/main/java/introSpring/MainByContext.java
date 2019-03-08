package introSpring;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainByContext {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext("introSpring");

        Cat cat = context.getBean(Cat.class); //Используем так, только если данный класс у нас один
        Dog dog = (Dog) context.getBean("dog");
        Mouse mouse = context.getBean("mouse", Mouse.class);

        Animal animal = context.getBean("dog", Animal.class);

        System.out.println(dog);
        System.out.println(cat);
        System.out.println(mouse);
        System.out.println(animal);

        context.close();
    }

}
