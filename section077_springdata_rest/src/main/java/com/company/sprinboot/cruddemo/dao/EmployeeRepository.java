package com.company.sprinboot.cruddemo.dao;

import com.company.sprinboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


//@RepositoryRestResource(path="members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
