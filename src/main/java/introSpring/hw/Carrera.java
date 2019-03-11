package introSpring.hw;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Carrera extends Garage {
    @Override
    public String getName() {
        return "Porsche Carrera S";
    }

    @Override
    public String getColor() {
        return "Space Grey";
    }
}
