package introSpring2.hw;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource({"classpath:introSpring2/hw/gabe.properties"})
public class Gabe {
    @Value("${voice}")
    private String voice;

    public String getVoice() {
        return voice;
    }

    @Override
    public String toString() {
        return "Gabe #33 " + getVoice();
    }
}
