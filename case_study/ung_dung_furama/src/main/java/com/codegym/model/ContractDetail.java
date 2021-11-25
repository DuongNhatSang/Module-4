package com.codegym.model;

import javax.persistence.*;

@Entity
@Table(name = "contractDetail")
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contractDetailId;

    @ManyToOne(targetEntity = Contract.class)
    @JoinColumn(name = "contract_id",referencedColumnName = "contractId")
    private Contract contract;

    @ManyToOne(targetEntity = AttachService.class)
    @JoinColumn(name = "attachService_id",referencedColumnName = "attachServiceId")
    private AttachService attachService;

    private int quantity;

    public ContractDetail() {
    }

    public ContractDetail(int contractDetailId, Contract contract, AttachService attachService, int quantity) {
        this.contractDetailId = contractDetailId;
        this.contract = contract;
        this.attachService = attachService;
        this.quantity = quantity;
    }

    public int getContractDetailId() {
        return contractDetailId;
    }

    public void setContractDetailId(int contractDetailId) {
        this.contractDetailId = contractDetailId;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
