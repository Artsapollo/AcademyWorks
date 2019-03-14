package introSpring2.hw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MayorSung {

    @Autowired
    private ChefHant chefHant;

    private String voice;

    public MayorSung(){
        voice = "We are powerful now, with " + (int) (Math.random() * 1000) + " great CCK troopers!";
    }

    @Override
    public String toString() {
        return chefHant + " MayorSung speech on TV: " + voice;
    }
}
