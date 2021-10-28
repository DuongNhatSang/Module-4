package com.codegym.repository;

import com.codegym.model.ToKhaiYTe;

import java.util.List;

public interface IToKhaiYTeRepository {
    void createToKhaiYTe(ToKhaiYTe toKhaiYTe);
    List<ToKhaiYTe> getListToKhaiYTe();
}
