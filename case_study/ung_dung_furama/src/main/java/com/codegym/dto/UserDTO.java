package com.codegym.dto;

import com.codegym.model.Employee;
import com.codegym.model.Role;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.Set;

public class UserDTO {

    private String userName;
    private String password;
    private long employee;


    public UserDTO() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getEmployee() {
        return employee;
    }

    public void setEmployee(long employee) {
        this.employee = employee;
    }


}
