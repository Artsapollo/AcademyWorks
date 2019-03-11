package introSpring.hw.garageConfig;

import introSpring.hw.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan("introSpring.hw")
public class GarageAppConfig {

    @Bean
    public Carrera returnCarrera(){
        return new Carrera();
    }

    @Bean("Evo")
    public Evo returnEvo(){
        return new Evo();
    }

    @Bean("Gtr")
    public Gtr returnGtr(){
        return new Gtr();
    }

    @Bean("Nsx")
    public Nsx returnNsx(){
        return new Nsx();
    }

    @Bean("Supra")
    public Supra returnSupra(){
        return new Supra();
    }
}
