package com.codegym.service.impl;

import com.codegym.model.Service;
import com.codegym.repository.IServiceRepository;
import com.codegym.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@org.springframework.stereotype.Service
public class ServiceServiceImpl implements IServiceService {
    @Autowired
    IServiceRepository serviceRepository;
    @Override
    public void save(Service service) {
        serviceRepository.save(service);
    }

    @Override
    public List<Service> findAllList() {
        return serviceRepository.findAll();
    }

    @Override
    public Service findById(int id) {
        return serviceRepository.findById(id).get();
    }
}
