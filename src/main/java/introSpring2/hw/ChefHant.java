package introSpring2.hw;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ChefHant {
    private String voice;

    public ChefHant(){
        voice = "Our CCK squad already has " + (int) (Math.random() * 1000) + " troopers!" ;
    }

    @Override
    public String toString() {
        return "Chefs Hant report: " + voice;
    }
}
