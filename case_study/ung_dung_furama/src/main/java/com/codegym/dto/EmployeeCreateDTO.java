package com.codegym.dto;

import com.codegym.model.Division;
import com.codegym.model.Education;
import com.codegym.model.Position;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class EmployeeCreateDTO {
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

    @NotNull(message = "không được để trống")
    @Min(value = 0, message = "Phải là số dương")
    private double salary;

    @NotBlank(message = "không được để trống")
    private String address;

    private long position;
    private long education;
    private long division;

    public EmployeeCreateDTO() {
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getPosition() {
        return position;
    }

    public void setPosition(long position) {
        this.position = position;
    }

    public long getEducation() {
        return education;
    }

    public void setEducation(long education) {
        this.education = education;
    }

    public long getDivision() {
        return division;
    }

    public void setDivision(long division) {
        this.division = division;
    }
}
