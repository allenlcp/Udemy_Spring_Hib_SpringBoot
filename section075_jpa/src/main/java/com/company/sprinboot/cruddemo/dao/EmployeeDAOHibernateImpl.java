package com.company.sprinboot.cruddemo.dao;

import com.company.sprinboot.cruddemo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

    // define field for entitymanager
    private EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public EmployeeDAOHibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        // get teh current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // create a query
        Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);

        // execute query and get result list
        List<Employee> employees = theQuery.getResultList();

        // return results
        return employees;
    }

    @Override
    public Employee findById(int theId) {
        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // get employee
        Employee theEmployee = currentSession.get(Employee.class, theId);

        // return employee
        return theEmployee;
    }

    @Override
    public void save(Employee theEmployee) {
        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // get employee
        currentSession.saveOrUpdate(theEmployee);
    }

    @Override
    public void deleteByID(int theId) {
        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // delete employee
        Query theQuery = currentSession.createQuery("delete from Employee where id=:employeeId");
        theQuery.setParameter("employeeId", theId);
        theQuery.executeUpdate();
    }
}
