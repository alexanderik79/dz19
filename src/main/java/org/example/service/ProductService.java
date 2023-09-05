package org.example.service;

import org.example.entity.Customer;
import org.example.entity.Product;

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

    public void countExtended(){
        productDao.countExtended();
    }
    public List<Product> getAllProducts(){
        return productDao.findAll();
    }
}
