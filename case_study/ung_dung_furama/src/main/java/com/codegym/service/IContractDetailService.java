package com.codegym.service;


import com.codegym.model.ContractDetail;

import java.util.List;

public interface IContractDetailService {
    List<ContractDetail> findByContractId(int id);
}
