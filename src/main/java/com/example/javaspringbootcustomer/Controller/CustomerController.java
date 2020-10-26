package com.example.javaspringbootcustomer.Controller;

import com.example.javaspringbootcustomer.Model.Customer;
import com.example.javaspringbootcustomer.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/update/{id}")
    public void updateCustomer(@PathVariable("id")String id , @RequestBody Customer customer){
        customerService.updateCustomer(id,customer);
    }

    @PostMapping("/insert")
    public void updateCustomer( @RequestBody Customer customer){
        customerService.insertCustomer(customer);
    }

    @DeleteMapping("/delete/{id}")
    public void updateCustomer( @PathVariable("id")String id){
        customerService.deleteCustomer(id);
    }

}
