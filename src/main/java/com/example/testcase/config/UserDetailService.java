package com.example.testcase.config;

import com.example.testcase.dao.UserDao;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService implements UserDetailsService {
    UserDao userDao;

    public UserDetailService(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetailsImpl userDetails = new UserDetailsImpl(userDao.getUserByLogin(username));
        if (userDetails.getUser()==null) throw new UsernameNotFoundException("User not found");
        return userDetails;
    }
}
