package com.example.javaspringbootcustomer.Services;

import com.example.javaspringbootcustomer.Model.Customer;
import com.example.javaspringbootcustomer.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> findAll(){
       return customerRepository.findAll();
    }
}
