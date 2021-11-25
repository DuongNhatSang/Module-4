package com.codegym.service.impl;

import com.codegym.model.AttachService;
import com.codegym.repository.IAttachServiceRepository;
import com.codegym.service.IAttachServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AttachServiceServiceImpl  implements IAttachServiceService {
    @Autowired
    IAttachServiceRepository attachServiceRepository;
    @Override
    public List<AttachService> findAll() {
        return attachServiceRepository.findAll();
    }
    @Override
    public AttachService findById(int id) {
        return attachServiceRepository.findById(id).get();
    }

}
