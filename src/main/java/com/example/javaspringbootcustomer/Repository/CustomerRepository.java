package com.example.javaspringbootcustomer.Repository;

import com.example.javaspringbootcustomer.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository  extends JpaRepository<Customer,String> {
    public List<Customer> findByRegion(String region);

    @Query("select u from Customer u where u.age > ?1")
    List<Customer> findByAgethan(int age);
}
