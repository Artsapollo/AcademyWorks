package introSpring2.hw;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

@Component
public class TraneConfigBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        GenericBeanDefinition gbd = new GenericBeanDefinition();
        gbd.setBeanClass(Trane.class);
        gbd.getPropertyValues().add("voice", "Still Free Crew");

        ((DefaultListableBeanFactory) beanFactory).registerBeanDefinition("trane2", gbd);
    }
}
