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

    public void updateCustomer(String id,Customer customer){
        Customer co = customerRepository.findById(id).isPresent()?customerRepository.findById(id).get():null;
        co.setAge(customer.getAge());
        co.setCar(customer.isCar());
        co.setCurrentAct(customer.isCurrentAct());
        co.setIncome(customer.getIncome());
        co.setMarried(customer.isMarried());
        co.setMortgage(customer.isMortgage());
        co.setPep(customer.isPep());
        co.setRegion(customer.getRegion());
        co.setSaveAct(customer.isSaveAct());
        co.setSex(customer.isSex());
        customerRepository.save(co);
    }

    public void deleteCustomer(String id){
        Customer co = customerRepository.findById(id).isPresent()?customerRepository.findById(id).get():null;
        customerRepository.delete(co);
    }

    public void insertCustomer(Customer customer){
        customerRepository.save(customer);
    }
}
