package com.codegym.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "customer")
public class Customer{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long customerId;
    @ManyToOne(targetEntity = CustomerType.class)
    @JoinColumn(name = "customerType_id",referencedColumnName = "customerTypeId")
    private CustomerType customerType;
    private String address;
    private Boolean gender;
    private String fullName;
    @Column(columnDefinition = "Date")
    private String birthDay;
    private String phoneNumber;
    private String email;
    private String idCard;
    @OneToMany(mappedBy = "customer")
    @JsonBackReference(value="back_class")
    private Set<Contract> contracts;


    public Customer() {
    }

    public Customer(long customerId, CustomerType customerType, String address, Boolean gender, String fullName,
                    String birthDay, String phoneNumber, String email, String idCard) {
        this.customerId = customerId;
        this.customerType = customerType;
        this.address = address;
        this.gender = gender;
        this.fullName = fullName;
        this.birthDay = birthDay;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.idCard = idCard;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }
}
