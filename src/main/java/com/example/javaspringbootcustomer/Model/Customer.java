package com.example.javaspringbootcustomer.Model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "Customer")
public class Customer {
    @Id
    private String id;
    private int age;
    private boolean sex;
    private String region;
    private double income;
    private boolean married;
    private boolean car;
    private boolean saveAct;
    private boolean currentAct;
    private boolean mortgage;
    private boolean pep;
    public Customer(){

    }
    public Customer(String id, int age, boolean sex, String region, double income, boolean married, boolean car, boolean saveAct, boolean currentAct, boolean mortgage, boolean pep) {
        this.id = id;
        this.age = age;
        this.sex = sex;
        this.region = region;
        this.income = income;
        this.married = married;
        this.car = car;
        this.saveAct = saveAct;
        this.currentAct = currentAct;
        this.mortgage = mortgage;
        this.pep = pep;
    }
}
