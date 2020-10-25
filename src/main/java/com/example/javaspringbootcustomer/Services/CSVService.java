package com.example.javaspringbootcustomer.Services;

import com.example.javaspringbootcustomer.Model.Customer;
import com.example.javaspringbootcustomer.Repository.CSVHelper;
import com.example.javaspringbootcustomer.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@Service
public class CSVService {
    @Autowired
    CustomerRepository repository;

    public void save(MultipartFile file) {
        try {
            List<Customer> customer = CSVHelper.csvToTutorials(file.getInputStream());
            repository.saveAll(customer);
        } catch (IOException  e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }

    public ByteArrayInputStream load() {
        List<Customer> tutorials = repository.findAll();

        ByteArrayInputStream in = CSVHelper.toCSV(tutorials);
        return in;
    }

    public List<Customer> getAllTutorials() {
        return repository.findAll();
    }
}
