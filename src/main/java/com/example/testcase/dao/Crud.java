package com.example.testcase.dao;

import java.util.List;

public interface Crud<T> {
    T save(T t);
    List<T> findAll();

}
