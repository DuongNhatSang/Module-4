package com.codegym.dto;

import com.codegym.model.CustomerType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class CustomerCreateDTO {

    private long customerType;

    @NotBlank(message = "không được để trống")
    private String address;

    private Boolean gender;

    @NotBlank(message = "không được để trống")
    private String fullName;

    @NotBlank(message = "không được để trống")
    private String birthDay;

    @NotBlank(message = "không được để trống")
    @Pattern(regexp = "(090|091)[\\d]{7}",message = "Không đúng định dạng")
    private String phoneNumber;

    @NotBlank(message = "không được để trống")
    @Pattern(regexp = "[a-z]+[a-zA-Z0-9]+@[a-zA-Z0-9]+(\\.[a-zA-Z0-9]+\\.*[a-zA-Z0-9]*)",message = "Không đúng định dạng")
    private String email;

    @NotBlank(message = "không được để trống")
    @Pattern(regexp = "\\d{9}|\\d{12}",message = "Không đúng định dạng")
    private String idCard;

    public CustomerCreateDTO() {
    }

    public long getCustomerType() {
        return customerType;
    }

    public void setCustomerType(long customerType) {
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
