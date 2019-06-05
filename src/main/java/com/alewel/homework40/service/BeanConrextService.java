package com.alewel.homework40.service;

import com.alewel.homework40.dto.BeanContext;

import java.util.List;

public interface BeanConrextService {
    List<BeanContext> findAll ();

    public Long save(BeanContext beanContext);
}
