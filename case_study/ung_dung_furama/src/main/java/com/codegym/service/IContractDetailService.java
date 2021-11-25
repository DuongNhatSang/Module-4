package com.codegym.service;


import com.codegym.dto.ContractDetailDTO;
import com.codegym.model.ContractDetail;

import java.util.List;

public interface IContractDetailService {
    List<ContractDetailDTO> findByContractId(int id);
    void save(ContractDetail contractDetail);
}
