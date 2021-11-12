package com.codegym.service.impl;

import com.codegym.model.Service;
import com.codegym.repository.IServiceRepository;
import com.codegym.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;



@org.springframework.stereotype.Service
public class ServiceServiceImpl implements IServiceService {
    @Autowired
    IServiceRepository serviceRepository;
    @Override
    public void save(Service service) {
        serviceRepository.save(service);
    }
}
