package com.codegym.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "employee")
public class Employee{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long employeeId;
    private String fullName;
    private String birthDay;
    private String phoneNumber;
    private String email;
    private String idCard;
    private double salary;
    private String address;
    @ManyToOne(targetEntity = Position.class)
    @JoinColumn(name = "position_id",referencedColumnName = "positionId")
    private Position position;
    @ManyToOne(targetEntity = Education.class)
    @JoinColumn(name = "education_id",referencedColumnName = "educationId")
    private Education education;
    @ManyToOne(targetEntity = Division.class)
    @JoinColumn(name = "division_id",referencedColumnName = "divisionId")
    private Division division;
    @OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
    private Set<Contract> contracts;



    public Employee() {
    }

    public Employee(long employeeId, String fullName, String birthDay, String phoneNumber, String email, String idCard,
                    double salary, String address, Position position, Education education, Division division) {
        this.employeeId = employeeId;
        this.fullName = fullName;
        this.birthDay = birthDay;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.idCard = idCard;
        this.salary = salary;
        this.address = address;
        this.position = position;
        this.education = education;
        this.division = division;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }
}
