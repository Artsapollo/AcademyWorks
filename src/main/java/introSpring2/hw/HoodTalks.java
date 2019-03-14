package introSpring2.hw;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HoodTalks {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext("introSpring2.hw");

        Gabe gabe = context.getBean(Gabe.class);
        System.out.println(gabe);

        Trane trane = context.getBean("trane", Trane.class);
        System.out.println(trane);

        Trane trane2 = context.getBean("trane2", Trane.class);
        System.out.println(trane2);

        ChefHant chefHant = context.getBean(ChefHant.class);
        System.out.println(chefHant);

        MayorSung mayorSung = context.getBean(MayorSung.class);
        System.out.println(mayorSung);

        Decoy decoy = context.getBean(Decoy.class);
        System.out.println(decoy);

        context.close();
    }
}
