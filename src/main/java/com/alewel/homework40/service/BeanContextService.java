package com.alewel.homework40.service;

import com.alewel.homework40.dto.BeanContext;

import java.util.List;

public interface BeanContextService {
    List<BeanContext> findAll ();

    public Long save(BeanContext beanContext);
}
