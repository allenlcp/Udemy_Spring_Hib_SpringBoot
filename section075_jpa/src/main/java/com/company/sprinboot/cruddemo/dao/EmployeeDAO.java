package com.company.sprinboot.cruddemo.dao;

import com.company.sprinboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> findAll();
    public Employee findById(int theId);
    public void save(Employee theEmployee);
    public void deleteByID(int theId);
}
