package xyz.tomd.facehugger;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Iterator;

public class ApplicationStartedEventListener implements ApplicationListener<ApplicationStartedEvent> {

    public void onApplicationEvent(ApplicationStartedEvent event) {
        System.out.println(event);

        ConfigurableApplicationContext context = event.getApplicationContext();
        ConfigurableListableBeanFactory beans = context.getBeanFactory();

        Iterator<String> it = beans.getBeanNamesIterator();
        System.out.println("**** DUMPING MY BEANS");
        String beanName = "";
        while (it.hasNext()) {
            try {
                beanName = it.next();
                BeanDefinition bean = beans.getBeanDefinition(beanName);
                System.out.println("**** " + beanName + " = " + bean.getBeanClassName());
            } catch (Exception e) {
                System.out.println("**** Skipping " + beanName + " : " + e.getMessage());
            }
        }
        System.out.println("**** END DUMP");
    }
}
