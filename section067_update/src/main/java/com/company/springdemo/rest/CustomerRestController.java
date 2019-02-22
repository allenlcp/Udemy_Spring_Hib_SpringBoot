package com.company.springdemo.rest;

import com.company.springdemo.entity.Customer;
import com.company.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    // autowire the CustomerService
    @Autowired
    private CustomerService customerService;

    // add mapping for GET /customers
    @GetMapping("/customers")
    public List<Customer> getCustomers(){
        return customerService.getCustomers();
    }

    // add mapping for GET /customers/{customerId}
    @GetMapping("/customers/{customerId}")
    public Customer getCustomer(@PathVariable int customerId){
        Customer customer = customerService.getCustomer(customerId);

        if(customer == null){
            throw new CustomerNotFoundException("Customer id not found - " + customerId);
        }

        return customer;
    }

    // add mapping for POST /customers - add new customer
    @PostMapping("/customers")
    public Customer getCustomer(@RequestBody Customer theCustomer){

        theCustomer.setId(0);  // -> ID of 0 means DAO code will "INSERT" new customer
        customerService.saveCustomer(theCustomer);

        return theCustomer;
    }


    // updating mapping for PUT /customers - update existing customer
    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer theCustomer){

        customerService.saveCustomer(theCustomer);

        return theCustomer;
    }

}
