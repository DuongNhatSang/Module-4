package com.codegym.service;

import com.codegym.model.Contract;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface IContractService {
    void save(Contract contract);
    List<Contract> findAll();
    Contract findById(Long id);
    void deleteContractByEmpl(long id);
    void deleteContractByCus(long id);
}
