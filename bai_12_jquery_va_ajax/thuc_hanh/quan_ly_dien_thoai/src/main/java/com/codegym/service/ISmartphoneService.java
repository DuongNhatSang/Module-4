package com.codegym.service;

import com.codegym.model.Smartphone;

import java.util.List;
import java.util.Optional;

public interface ISmartphoneService {
    List<Smartphone> findAll();

    Optional<Smartphone> findById(Long id);

    void save(Smartphone smartPhone);

    void remove(Long id);
}
