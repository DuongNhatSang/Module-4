package com.codegym.service;

import com.codegym.model.Education;


import java.util.List;

public interface IEducationService {
    List<Education> findAll();
    Education findById(long id);
}
