package com.codegym.repository;


import com.codegym.model.ContractDetail;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IContractDetailRepository extends JpaRepository<ContractDetail,Integer> {
    @Query(value="SELECT * FROM contract_detail WHERE contract_id = :id",nativeQuery = true)
    List<ContractDetail> getListByContractId(@Param("id")int id);
}
