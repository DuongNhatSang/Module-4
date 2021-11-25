package com.codegym.dto;

import com.codegym.model.AttachService;
import com.codegym.model.Contract;

import javax.persistence.*;

public class ContractDetailCreateDTO {

    private int contractDetailId;


    private Long contract;


    private int attachService;

    private int quantity;

    public ContractDetailCreateDTO() {
    }

    public int getContractDetailId() {
        return contractDetailId;
    }

    public void setContractDetailId(int contractDetailId) {
        this.contractDetailId = contractDetailId;
    }

    public Long getContract() {
        return contract;
    }

    public void setContract(Long contract) {
        this.contract = contract;
    }

    public int getAttachService() {
        return attachService;
    }

    public void setAttachService(int attachService) {
        this.attachService = attachService;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
