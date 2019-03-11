package introSpring.hw;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class GarageByContext {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext("introSpring.hw");

        Carrera carrera = context.getBean(Carrera.class);
        System.out.println(carrera);

        Evo evo = (Evo) context.getBean("Evo");
        evo.setColor("Black");
        System.out.println(evo);

        Gtr gtr = context.getBean("Gtr", Gtr.class);
        System.out.println(gtr);

        Car car = context.getBean("Nsx", Car.class);
        System.out.println(car);

        Supra supra = context.getBean("Supra", Supra.class);
        System.out.println(supra);

        context.close();
    }
}
