package introSpring2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource({"classpath:introSpring2/pig.properties"})
public class Pig {
    @Value("${voice}")
    private String voice;

    public String getVoice() {
        return voice;
    }

    @Override
    public String toString() {
        return "Pig says " + getVoice() + '\'';
    }
}
