package introSpring.hw;

import org.springframework.stereotype.Component;

@Component("Evo")
public class Evo extends Garage {
    @Override
    public String getName() {
        return "Mistubishi Lancer Evolution VIII";
    }

    @Override
    public String getColor() {
        return super.getColor();
    }
}
