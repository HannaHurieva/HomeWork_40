package com.alewel.homework40;

import com.alewel.homework40.dto.BeanContext;
import com.alewel.homework40.service.BeanConrextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application implements CommandLineRunner {
    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private BeanConrextService beanConrextService;

    public void displayAllBeans() {
        String[] allBeanNames = applicationContext.getBeanDefinitionNames();
        for (String beanName : allBeanNames) {
            System.out.println(applicationContext.getBean(beanName).hashCode());
            System.out.println(beanName);

            System.out.println(
                    ((ConfigurableApplicationContext) applicationContext)
                            .getBeanFactory()
                            .getBeanDefinition(beanName)
                            .getScope());

            System.out.println(applicationContext.isSingleton(beanName));
            System.out.println(applicationContext.isPrototype(beanName));

            System.out.println("**********");
            System.out.println();
        }
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

            beanConrextService.save(bean);
        }
    }

    @Override
    public void run(String... args) throws Exception {
        createTableBeans();
        displayAllBeans();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
