package com.codegym.service.impl;

import com.codegym.dto.CustomerUsingService;
import com.codegym.model.Customer;
import com.codegym.repository.ICustomerRepository;
import com.codegym.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    ICustomerRepository customerRepository;
    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer findById(long id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public void delete(Customer customer) {
        customerRepository.delete(customer);
    }

    @Override
    public Page<Customer> search(String nameCus, String customerType, Pageable pageable) {
        return customerRepository.search("%"+nameCus+"%","%"+customerType+"%",pageable);
    }

    @Override
    public List<Customer> findAllList() {
        return customerRepository.findAll();
    }

    @Override
    public List<CustomerUsingService> getListCustomerUsing() {
        return customerRepository.getListCustomerUsing();
    }
}
