package com.codegym.service.impl;

import com.codegym.model.Division;
import com.codegym.repository.IDivisionRepository;
import com.codegym.service.IDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionServiceImpl implements IDivisionService {
    @Autowired
    IDivisionRepository divisionRepository;

    @Override
    public List<Division> findAll() {
        return divisionRepository.findAll();
    }
}
