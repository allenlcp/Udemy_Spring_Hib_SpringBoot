package com.company.springdemo.dao;

import com.company.springdemo.entity.Customer;

import java.util.List;

public interface CustomerDAO {
    List<Customer> getCustomers();
}
