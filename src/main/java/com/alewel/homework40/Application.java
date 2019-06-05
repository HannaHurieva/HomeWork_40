package com.alewel.homework40;

import com.alewel.homework40.dto.BeanContext;
import com.alewel.homework40.service.BeanContextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application implements CommandLineRunner {
    private final ApplicationContext applicationContext;
    private final BeanContextService beanContextService;

    @Autowired
    public Application(ApplicationContext applicationContext, BeanContextService beanContextService) {
        this.applicationContext = applicationContext;
        this.beanContextService = beanContextService;
    }

    public void createTableBeans() {
        String[] allBeanNames = applicationContext.getBeanDefinitionNames();
        for (String beanName : allBeanNames) {
            BeanContext bean = new BeanContext();

            bean.setId((long) applicationContext.getBean(beanName).hashCode());

            bean.setName(beanName);

            bean.setScope(((ConfigurableApplicationContext) applicationContext)
                    .getBeanFactory()
                    .getBeanDefinition(beanName)
                    .getScope());

            bean.setSingleton(applicationContext.isSingleton(beanName));

            beanContextService.save(bean);
        }
    }

    @Override
    public void run(String... args) throws Exception {
        createTableBeans();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
