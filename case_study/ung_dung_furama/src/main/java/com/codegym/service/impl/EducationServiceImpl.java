package com.codegym.service.impl;

import com.codegym.model.Education;
import com.codegym.repository.IEducationRepository;
import com.codegym.service.IEducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationServiceImpl implements IEducationService {
    @Autowired
    IEducationRepository educationRepository;
    @Override
    public List<Education> findAll() {
        return educationRepository.findAll();
    }

    @Override
    public Education findById(long id) {
        return educationRepository.findById(id).get();
    }
}
