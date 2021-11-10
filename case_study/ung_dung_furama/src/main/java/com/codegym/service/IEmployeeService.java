package com.codegym.service;

import com.codegym.model.Customer;
import com.codegym.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmployeeService {
    Page<Employee> findAll(Pageable pageable);
    void save(Employee employee);
    Employee findById(long id);
    void delete(long id);
}
