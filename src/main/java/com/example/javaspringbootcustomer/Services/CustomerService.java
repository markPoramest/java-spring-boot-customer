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

    public Customer findbyId(String id) {
        return  customerRepository.findById(id).isPresent()?customerRepository.findById(id).get():null;
    }
    public List<Customer>findbyRegion(String region){
        return customerRepository.findByRegion(region);
    }

    public List<Customer>findbyagethan(int age){
        return customerRepository.findByAgethan(age);
    }
}
