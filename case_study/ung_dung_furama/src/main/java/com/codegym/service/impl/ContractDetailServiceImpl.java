package com.codegym.service.impl;

import com.codegym.dto.ContractDetailDTO;

import com.codegym.model.ContractDetail;
import com.codegym.repository.IContractDetailRepository;
import com.codegym.service.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class ContractDetailServiceImpl implements IContractDetailService {
    @Autowired
    IContractDetailRepository contractDetailRepository;

    @Override
    public List<ContractDetail> findByContractId(int id) {
        return contractDetailRepository.getListByContractId(id);
    }
}
