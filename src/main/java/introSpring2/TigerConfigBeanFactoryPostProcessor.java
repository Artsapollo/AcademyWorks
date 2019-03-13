package introSpring2;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

@Component
public class TigerConfigBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        GenericBeanDefinition gbd = new GenericBeanDefinition();
        gbd.setBeanClass(Tiger.class);
        gbd.getPropertyValues().add("voice", "MurrMeow");

        ((DefaultListableBeanFactory) beanFactory).registerBeanDefinition("tiger2", gbd);
    }
}
