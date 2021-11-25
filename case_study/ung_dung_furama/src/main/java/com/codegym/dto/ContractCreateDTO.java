package com.codegym.dto;

import com.codegym.model.Customer;
import com.codegym.model.Employee;
import com.codegym.model.Service;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ContractCreateDTO {
    @NotBlank(message = "không được để trống")
    private String contractStartDay;

    @NotBlank(message = "không được để trống")
    private String contractEndDay;


    @Min(value = 0,message = "Phải là số dương")
    private double deposit;


    @Min(value = 0,message = "Phải là số dương")
    private double totalMoney;

    private long employee;
    private long customer;
    private int service;

    public ContractCreateDTO() {
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

    public long getEmployee() {
        return employee;
    }

    public void setEmployee(long employee) {
        this.employee = employee;
    }

    public long getCustomer() {
        return customer;
    }

    public void setCustomer(long customer) {
        this.customer = customer;
    }

    public int getService() {
        return service;
    }

    public void setService(int service) {
        this.service = service;
    }
}
