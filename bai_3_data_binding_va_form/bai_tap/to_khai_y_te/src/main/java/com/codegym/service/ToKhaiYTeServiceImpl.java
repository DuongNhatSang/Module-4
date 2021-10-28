package com.codegym.service;

import com.codegym.model.ToKhaiYTe;
import com.codegym.repository.ToKhaiYTeRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToKhaiYTeServiceImpl implements IToKhaiYTeService{
    @Autowired
    private ToKhaiYTeRepositoryImpl toKhaiYTeRepository;
    @Override
    public void createToKhaiYTe(ToKhaiYTe toKhaiYTe) {
        toKhaiYTeRepository.createToKhaiYTe(toKhaiYTe);
    }
}
