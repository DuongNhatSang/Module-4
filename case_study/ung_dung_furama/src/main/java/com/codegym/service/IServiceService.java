package com.codegym.service;


import com.codegym.model.Service;

import java.util.List;

public interface IServiceService {
    void save(Service service);
    List<Service> findAllList();
    Service findById(int id);
}
