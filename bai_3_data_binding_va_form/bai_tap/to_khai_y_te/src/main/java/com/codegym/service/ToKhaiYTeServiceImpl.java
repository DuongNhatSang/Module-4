package com.codegym.service;

import com.codegym.model.ToKhaiYTe;
import com.codegym.repository.ToKhaiYTeRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToKhaiYTeServiceImpl implements IToKhaiYTeService{

    private ToKhaiYTeRepositoryImpl toKhaiYTeRepository = new ToKhaiYTeRepositoryImpl();
    @Override
    public void createToKhaiYTe(ToKhaiYTe toKhaiYTe) {
        toKhaiYTeRepository.createToKhaiYTe(toKhaiYTe);
    }

    @Override
    public List<ToKhaiYTe> getListToKhaiYTe() {
        return toKhaiYTeRepository.getListToKhaiYTe();
    }
}
