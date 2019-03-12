package introSpring.hw;

import org.springframework.stereotype.Component;

@Component("Evo")
public class Evo extends Garage {
    private String color;

    public Evo(String color) {
        this.color = color;
    }

    @Override
    public String getName() {
        return "Mistubishi Lancer Evolution VIII";
    }


    @Override
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
