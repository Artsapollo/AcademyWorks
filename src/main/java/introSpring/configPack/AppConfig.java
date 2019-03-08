package introSpring.configPack;

import introSpring.AbstractAnimal;
import introSpring.Cat;
import introSpring.Dog;
import introSpring.Mouse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan("introSpring")
public class AppConfig {

    @Bean
    public Cat returnCat(){
        return new Cat();
    }

    @Bean("dog")
    public Dog returnDog(){
        return new Dog();
    }

    @Bean("mouse")
    public Mouse returnMouse(){
        return new Mouse();
    }

    @Bean
    @Primary
    public Pig returnPig(){
        Pig pig = new Pig();
        pig.setColor("Black");
        return pig;
    }

    @Component("mainPig")
    public class Pig extends AbstractAnimal{
        private String color = "Pink";

        @Override
        public String getVoice() {
            return "Oink-oink";
        }

        public void setColor(String color) {
            this.color = color;
        }

        @Override
        public String toString() {
            return "Pig[ " + super.toString() + "color = '" + color + '\'' + ']';
        }
    }

}
