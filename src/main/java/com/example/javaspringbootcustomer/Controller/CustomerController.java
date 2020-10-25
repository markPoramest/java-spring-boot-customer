package com.example.javaspringbootcustomer.Controller;

import com.example.javaspringbootcustomer.Model.Customer;
import com.example.javaspringbootcustomer.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        return  customerService.findAll();
    }

    @GetMapping("/findbyid/{id}")
    public Customer findbyId(@PathVariable("id") String id){
        return customerService.findbyId(id);
    }
    @GetMapping("/findbyRegion/{region}")
    public List<Customer> findbyIregion(@PathVariable("region") String region){
        return customerService.findbyRegion(region);
    }
    @GetMapping("/findbyagethan/{age}")
    public List<Customer> findbyagethan(@PathVariable("age") String age){
        return customerService.findbyagethan(Integer.parseInt(age));
    }

}
