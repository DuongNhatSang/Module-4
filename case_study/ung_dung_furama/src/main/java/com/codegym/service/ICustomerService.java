package com.codegym.service;

import com.codegym.dto.CustomerUsingService;
import com.codegym.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ICustomerService {
    Page<Customer> findAll(Pageable pageable);
    void save(Customer customer);
    Customer findById(long id);
    void delete(Customer customer);
    Page<Customer> search(String nameCus, String customerType, Pageable pageable);
    List<Customer> findAllList();
    List<CustomerUsingService> getListCustomerUsing();
}
