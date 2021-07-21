package com.example.testcase.dao;

import com.example.testcase.models.Contract;
import com.example.testcase.models.enums.Status;

import java.util.List;

public interface ContractDao extends Crud<Contract> {
    @Override
    Contract save(Contract contract);

    @Override
    List<Contract> findAll();

    Contract getById(Long id);

    void setStatusOfContractById(Long id, Status status);
}
