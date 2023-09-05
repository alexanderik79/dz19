package org.example.service;

import org.example.entity.Customer;
import org.example.entity.Product;

import java.util.List;

public class ProductService {
    private final ProductDaoImpl productDao = new ProductDaoImpl();

    public void save (Product product){
        productDao.save(product);
    }
}
