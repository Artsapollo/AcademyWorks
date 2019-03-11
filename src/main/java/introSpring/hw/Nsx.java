package introSpring.hw;

import org.springframework.stereotype.Component;

@Component("Nsx")
public class Nsx extends Garage {
    @Override
    public String getName() {
        return "Honda NSX";
    }

    @Override
    public String getColor() {
        return "Red sunrise";
    }
}
