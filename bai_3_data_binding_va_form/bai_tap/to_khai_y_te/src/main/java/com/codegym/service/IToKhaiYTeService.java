package com.codegym.service;

import com.codegym.model.ToKhaiYTe;

import java.util.List;

public interface IToKhaiYTeService {
    void createToKhaiYTe(ToKhaiYTe toKhaiYTe);
    List<ToKhaiYTe> getListToKhaiYTe();
}
