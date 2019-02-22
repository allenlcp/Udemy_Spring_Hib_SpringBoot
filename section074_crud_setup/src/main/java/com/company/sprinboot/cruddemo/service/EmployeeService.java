package com.company.sprinboot.cruddemo.service;


import com.company.sprinboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> findAll();
    public Employee findById(int theId);
    public void save(Employee theEmployee);
    public void deleteByID(int theId);

}
