package com.codegym.dto;

import com.codegym.model.CustomerType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class CustomerDTO {
    private long customerId;
    private CustomerType customerType;

    @NotBlank(message = "không được để trống")
    private String address;

    private Boolean gender;

    @NotBlank(message = "không được để trống")
    private String fullName;

    @NotBlank(message = "không được để trống")
    private String birthDay;


    @Pattern(regexp = "(090|091)[\\d]{7}",message = "Không đúng định dạng")
    private String phoneNumber;


    @Pattern(regexp = "[a-z]+[a-zA-Z0-9]+@[a-zA-Z0-9]+(\\.[a-zA-Z0-9]+\\.*[a-zA-Z0-9]*)",message = "Không đúng định dạng")
    private String email;


    @Pattern(regexp = "\\d{9}|\\d{12}",message = "Không đúng định dạng")
    private String idCard;

    public CustomerDTO() {
    }

    public CustomerDTO(long customerId, CustomerType customerType, String address, Boolean gender, String fullName,
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
}
