package com.codegym.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "division")
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long divisionId;
    private String divisionName;
    @OneToMany(mappedBy = "division")
    @JsonBackReference(value="back_class")
    private Set<Employee> employees;

    public Division() {
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public long getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(long divisionId) {
        this.divisionId = divisionId;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }
}
