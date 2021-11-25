package com.codegym.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "contract")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long contractId;

    @Column(columnDefinition = "Date")
    private String contractStartDay;

    @Column(columnDefinition = "Date")
    private String contractEndDay;

    private double deposit;
    private double totalMoney;

    @ManyToOne(targetEntity = Employee.class)
    @JoinColumn(name = "employee_id",referencedColumnName = "employeeId")
    private Employee employee;

    @ManyToOne(targetEntity = Customer.class)
    @JoinColumn(name = "customer_id",referencedColumnName = "customerId")
    private Customer customer;

    @ManyToOne(targetEntity = Service.class)
    @JoinColumn(name = "service_id",referencedColumnName = "serviceId")
    private Service service;

    @OneToMany(mappedBy = "contract")
    @JsonBackReference(value="back_class")
    private Set<ContractDetail> contractDetails;

    public Contract() {
    }

    public Contract(long contractId, String contractStartDay, String contractEndDay, double deposit, double totalMoney,
                    Employee employee, Customer customer, Service service) {
        this.contractId = contractId;
        this.contractStartDay = contractStartDay;
        this.contractEndDay = contractEndDay;
        this.deposit = deposit;
        this.totalMoney = totalMoney;
        this.employee = employee;
        this.customer = customer;
        this.service = service;
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

    public Set<ContractDetail> getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(Set<ContractDetail> contractDetails) {
        this.contractDetails = contractDetails;
    }
}

