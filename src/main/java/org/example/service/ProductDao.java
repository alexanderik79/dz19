package org.example.service;

import org.example.entity.Product;

import java.util.List;

public interface ProductDao {
    void save (Product product);
    Product getById (int id);
    List<Product> findAll();
    void updateById (int id);
}