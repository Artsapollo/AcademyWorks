package introSpring.hw;

import org.springframework.stereotype.Component;

@Component("Supra")
public class Supra extends Garage {
    @Override
    public String getName() {
        return "Toyota supra";
    }

    @Override
    public String getColor() {
        return "Black";
    }
}
