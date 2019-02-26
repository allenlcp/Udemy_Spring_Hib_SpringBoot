package com.company.springsecurity.demo.dao;

import com.company.springsecurity.demo.entity.User;

public interface UserDao {

    User findByUserName(String userName);
    
    void save(User user);
    
}
