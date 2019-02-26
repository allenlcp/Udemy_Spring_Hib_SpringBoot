package com.company.springsecurity.demo.service;


import com.company.springsecurity.demo.entity.User;
import com.company.springsecurity.demo.user.CrmUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findByUserName(String userName);

    void save(CrmUser crmUser);
}
