package com.alewel.homework40;

import com.alewel.homework40.dto.BeanContext;
import com.alewel.homework40.repository.BeanContextCreateTable;
import com.alewel.homework40.service.BeanContextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application implements CommandLineRunner {
    @Autowired
    private BeanContextCreateTable beanContextCreateTable;

    @Override
    public void run(String... args) throws Exception {
        beanContextCreateTable.createTableBeans();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
