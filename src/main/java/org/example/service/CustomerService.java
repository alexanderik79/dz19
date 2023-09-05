package org.example.service;

import org.example.entity.Customer;

public class CustomerService {
    private final CustomerDaoImpl customerDao = new CustomerDaoImpl();

    public void save (Customer customer){
        customerDao.save(customer);
    }
}