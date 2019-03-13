package introSpring2;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Start {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext("introSpring2");
        Pig pig = context.getBean(Pig.class);
        System.out.println(pig);

        Tiger tiger = context.getBean("tiger", Tiger.class);
        System.out.println(tiger);

        Tiger tiger2 = context.getBean("tiger2", Tiger.class);
        System.out.println(tiger2);

        Bloha bloha = context.getBean(Bloha.class);
        System.out.println(bloha);

        Bloha bloha2 = context.getBean(Bloha.class);
        System.out.println(bloha2);

        Cat cat = context.getBean(Cat.class);
        System.out.println(cat);

        Cat cat2 = context.getBean(Cat.class);
        System.out.println(cat2);

        Kakadu kakadu = context.getBean(Kakadu.class);
        System.out.println(kakadu);

        context.close();

    }
}
