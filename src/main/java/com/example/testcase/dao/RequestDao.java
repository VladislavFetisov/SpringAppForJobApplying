package com.example.testcase.dao;

import com.example.testcase.models.Request;

import java.util.List;

public interface RequestDao extends Crud<Request> {

    @Override
    Request save(Request request);

    @Override
    List<Request> findAll();

    Request findById(Long id);


}
