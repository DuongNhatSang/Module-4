package com.codegym.repository;

import com.codegym.dto.ContractDetailDTO;
import com.codegym.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface IContractRepository extends JpaRepository<Contract,Long> {
    @Transactional
    @Modifying
    @Query(value="DELETE FROM contract WHERE employee_id = :id",nativeQuery = true)
    void deleteContractByEmpl(@Param("id")long id);

    @Transactional
    @Modifying
    @Query(value="DELETE FROM contract WHERE customer_id = :id",nativeQuery = true)
    void deleteContractByCus(@Param("id")long id);
}
