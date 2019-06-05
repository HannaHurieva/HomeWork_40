package com.alewel.homework40.service.impl;

import com.alewel.homework40.dto.BeanContext;
import com.alewel.homework40.service.BeanConrextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alewel.homework40.repository.BeanContextRepo;

import java.util.List;

@Service
public final class BeanContextServiceImpl implements BeanConrextService {

    private final BeanContextRepo beanContextRepo;

    @Autowired
    public BeanContextServiceImpl(BeanContextRepo beanContextRepo) {
        this.beanContextRepo = beanContextRepo;
    }

    @Override
    public List<BeanContext> findAll() {
        return beanContextRepo.findAll();
    }

    @Override
    public Long save(BeanContext beanContext) {
        return beanContextRepo.save(beanContext).getId();
    }
}
