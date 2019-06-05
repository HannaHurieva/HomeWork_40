package com.alewel.homework40.repository;

import com.alewel.homework40.dto.BeanContext;
import com.alewel.homework40.service.BeanContextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Repository;

@Repository
public class BeanContextCreateTable {
    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private BeanContextService beanContextService;

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
}
