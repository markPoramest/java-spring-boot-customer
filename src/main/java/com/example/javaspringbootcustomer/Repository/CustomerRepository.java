package com.example.javaspringbootcustomer.Repository;

import com.example.javaspringbootcustomer.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository  extends JpaRepository<Customer,String> {

}
