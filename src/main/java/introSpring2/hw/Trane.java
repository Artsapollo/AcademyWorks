package introSpring2.hw;

import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component("trane")
@DependsOn("gabe")
public class Trane {
    private Gabe gabe = new Gabe(){
        @Override
        public String getVoice() {
            return "Vandals here";
        }
    };

    private String voice;

    public Trane(){

    }

    public Trane(Gabe gabe){
        this.gabe = gabe;
    }

    public String getVoice() {
        return voice;
    }

    public void setVoice(String voice) {
        this.voice = voice;
    }

    @Override
    public String toString() {
        return "Trane " + getVoice() + (Objects.nonNull(gabe) ? " no Vandals appreciate. " + gabe.getVoice() : "");
    }
}
