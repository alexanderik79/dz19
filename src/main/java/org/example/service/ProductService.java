package org.example.service;

import org.example.entity.Customer;
import org.example.entity.Order;
import org.example.entity.Product;
import org.example.service.daoimplements.ProductDaoImpl;

import java.util.Collections;
import java.util.List;

public class ProductService {
    private final ProductDaoImpl productDao = new ProductDaoImpl();

    public void save (Product product){
        productDao.save(product);
    }
    public void updateById(int id){
        productDao.updateById(id);
    }
    public void countOrders(){
        productDao.countOrders();
    }
    public List<Customer> countOrders2(){
        return productDao.countOrders2();
    }
    public List<Order> countExtended2(){
        return productDao.countExtended2();
    }

    public void countExtended(){
        productDao.countExtended();
    }
    public List<Product> getAllProducts(){
        return productDao.findAll();
    }
}
