package com.codegym.repository;

import com.codegym.dto.CustomerUsingService;
import com.codegym.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICustomerRepository extends JpaRepository<Customer,Long> {
    @Query(value="SELECT * FROM customer WHERE full_name LIKE :nameCus AND customer_type_id LIKE :customerType", nativeQuery = true)
    Page<Customer> search(@Param("nameCus")String nameCus, @Param("customerType") String customerType, Pageable pageable);

    @Query(value="CALL create_customer_use_service()",nativeQuery = true)
    List<CustomerUsingService> getListCustomerUsing();
}
