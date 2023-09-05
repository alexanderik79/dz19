package org.example.service;

import org.example.entity.Customer;
import org.example.entity.Product;

import java.util.List;

public interface CustomerDao {
    void save (Customer customer);
    Customer getById (int id);
    List<Customer> findAll();
    void updateById (int id);
}
