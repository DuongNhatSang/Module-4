package com.codegym.service.impl;

import com.codegym.model.Contract;
import com.codegym.repository.IContractRepository;
import com.codegym.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractServiceImpl implements IContractService {
    @Autowired
    IContractRepository contractRepository;
    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public List<Contract> findAll() {
       return contractRepository.findAll();
    }

    @Override
    public Contract findById(Long id) {
        return contractRepository.findById(id).get();
    }

    @Override
    public void deleteContractByEmpl(long id) {
        contractRepository.deleteContractByEmpl(id);
    }

    @Override
    public void deleteContractByCus(long id) {
        contractRepository.deleteContractByCus(id);
    }


}

