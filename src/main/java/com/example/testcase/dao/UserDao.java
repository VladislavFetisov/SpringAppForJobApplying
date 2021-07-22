package com.example.testcase.dao;

import com.example.testcase.models.User;
import org.springframework.stereotype.Repository;


public interface UserDao extends Crud<User>{
    User getUserByLogin(String login);
}
