package com.example.javaspringbootcustomer.Controller;

import com.example.javaspringbootcustomer.Model.Customer;
import com.example.javaspringbootcustomer.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/findAll")
    public List<Customer> findAll(){
        return  customerService.findAll()  ;
    }
}
