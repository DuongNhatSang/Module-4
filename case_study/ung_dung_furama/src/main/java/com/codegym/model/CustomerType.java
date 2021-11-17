package com.codegym.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "customerType")
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long customerTypeId;
    private String customerTypeName;
    @OneToMany(mappedBy = "customerType",cascade = CascadeType.ALL)
    private Set<Customer> customers;

    public CustomerType() {
    }

    public CustomerType(long customerTypeId, String customerTypeName, Set<Customer> customers) {
        this.customerTypeId = customerTypeId;
        this.customerTypeName = customerTypeName;
        this.customers = customers;
    }

    public long getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(long customerTypeId) {
        this.customerTypeId = customerTypeId;
    }

    public String getCustomerTypeName() {
        return customerTypeName;
    }

    public void setCustomerTypeName(String customerTypeName) {
        this.customerTypeName = customerTypeName;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }
}
