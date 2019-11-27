package xyz.tomd.facehugger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.w3c.dom.Document;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

public class ApplicationStartedEventListener implements ApplicationListener<ApplicationPreparedEvent> {

    public void onApplicationEvent(ApplicationPreparedEvent event) {
        // ApplicationPreparedEvent = before any duplicate beans are loaded.
        ResourceLoader loader = event.getApplicationContext();

        String location = "classpath:beans2.xml";

        try {
            Resource[] resources = ((ConfigurableApplicationContext) loader).getResources(location);
            System.out.println(resources);

            // Loop over the Resources and parse 'em
            for (Resource resource : resources) {
                InputStream inputStream = resource.getInputStream();
                System.out.println(inputStream);

            }

        } catch (IOException ex) {
            System.err.println("OH NOES!");
        }



//        ConfigurableApplicationContext context = event.getApplicationContext();
//        ConfigurableListableBeanFactory beans = context.getBeanFactory();
//
//        Iterator<String> it = beans.getBeanNamesIterator();
//        System.out.println("**** DUMPING MY BEANS");
//        String beanName = "";
//        while (it.hasNext()) {
//            try {
//                beanName = it.next();
//                BeanDefinition bean = beans.getBeanDefinition(beanName);
//                System.out.println("**** " + beanName + " = " + bean.getBeanClassName());
//            } catch (Exception e) {
//                System.out.println("**** Skipping " + beanName + " : " + e.getMessage());
//            }
//        }
//        System.out.println("**** END DUMP");
    }
}
