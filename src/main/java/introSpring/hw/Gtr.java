package introSpring.hw;

import org.springframework.stereotype.Component;

@Component("Gtr")
public class Gtr extends Garage {
    @Override
    public String getName() {
        return "Nissan Skyline GTR";
    }

    @Override
    public String getColor() {
        return "Light blue";
    }
}
