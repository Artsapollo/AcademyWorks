package introSpring.hw;

import introSpring.hw.garageConfig.GarageAppConfig;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class GarageByConfig {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(GarageAppConfig.class);

        Carrera carrera = context.getBean(Carrera.class);
        System.out.println(carrera);

        Evo evo = (Evo) context.getBean("Evo");
        System.out.println(evo);

        Gtr gtr = context.getBean("Gtr", Gtr.class);
        System.out.println(gtr);

//        Car car = context.getBean( Car.class);
//        System.out.println(car);
//
//        Supra supra = context.getBean("Supra", Supra.class);
//        System.out.println(supra);

        context.close();
    }
}
