package com.example.testcase.repositories;

import com.example.testcase.models.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface ContractRepository extends JpaRepository<Contract, Long> {
    @Modifying
    @Transactional
    @Query(value = "update contracts set status=:state where contract_id=:contractId", nativeQuery = true)
    void setStatusOfContractById(@Param("contractId") Long id, @Param("state") String status);
}
