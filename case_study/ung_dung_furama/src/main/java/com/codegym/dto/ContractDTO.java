package com.codegym.dto;

import com.codegym.model.Customer;
import com.codegym.model.Employee;
import com.codegym.model.Service;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class ContractDTO {
    private long contractId;

    @NotBlank(message = "không được để trống")
    private String contractStartDay;

    @NotBlank(message = "không được để trống")
    private String contractEndDay;

    @NotNull(message = "không được để trống")
    @Min(0)
    private double deposit;

    @NotNull(message = "không được để trống")
    @Min(0)
    private double totalMoney;
    private Employee employee;
    private Customer customer;
    private Service service;

    public ContractDTO() {
    }

    public long getContractId() {
        return contractId;
    }

    public void setContractId(long contractId) {
        this.contractId = contractId;
    }

    public String getContractStartDay() {
        return contractStartDay;
    }

    public void setContractStartDay(String contractStartDay) {
        this.contractStartDay = contractStartDay;
    }

    public String getContractEndDay() {
        return contractEndDay;
    }

    public void setContractEndDay(String contractEndDay) {
        this.contractEndDay = contractEndDay;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
