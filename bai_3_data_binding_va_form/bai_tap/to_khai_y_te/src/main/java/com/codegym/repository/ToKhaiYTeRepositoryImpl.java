package com.codegym.repository;

import com.codegym.model.ToKhaiYTe;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ToKhaiYTeRepositoryImpl implements IToKhaiYTeRepository{
    private List<ToKhaiYTe> toKhaiYTeList = new ArrayList<>();
    @Override
    public void createToKhaiYTe(ToKhaiYTe toKhaiYTe) {
        toKhaiYTeList.add(toKhaiYTe);
    }
}
