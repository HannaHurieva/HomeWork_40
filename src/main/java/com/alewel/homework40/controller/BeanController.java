package com.alewel.homework40.controller;

import com.alewel.homework40.dto.BeanContext;
import com.alewel.homework40.service.BeanContextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class BeanController {

    private final BeanContextService beanConrextService;

    @Autowired
    public BeanController(BeanContextService beanConrextService) {
        this.beanConrextService = beanConrextService;
    }

    @GetMapping("beans")
    public List<BeanContext> getListOfBeans(){
        return beanConrextService.findAll();
    }
}
