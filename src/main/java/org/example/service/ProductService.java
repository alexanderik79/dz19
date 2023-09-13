package org.example.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.entity.Customer;
import org.example.entity.Order;
import org.example.entity.Product;
import org.example.service.daoimplements.ProductDaoImpl;

import java.util.Collections;
import java.util.List;

public class ProductService {
    private final ProductDaoImpl productDao = new ProductDaoImpl();
    Logger logger = LogManager.getLogger(ProductService.class);


    public void save (Product product){
        if(product == null){
            logger.error("product is NULL!!!");
        }
        else {
            logger.warn("Start saving product " + product.getNname() + ".");
            productDao.save(product);
            logger.info("product " + product.getNname() + " was saved.");
        }
    }
    public void updateById(int id){
        if(id < 1){
            logger.error("id can not be less than 1 !!!");
        }
        else {
            logger.warn("Start saving product id: " + id + ".");
            productDao.updateById(id);
            logger.info("product id: " + id + " was updated.");
        }
    }
    public void countOrders(){
        logger.info("receiving data from database ...");
        productDao.countOrders();

    }
    public List<Customer> countOrders2(){
        logger.info("receiving data from database ...");
        return productDao.countOrders2();
    }
    public List<Order> countExtended2(){
        logger.info("receiving data from database ...");
        return productDao.countExtended2();
    }

    public void countExtended(){
        logger.info("receiving data from database ...");
        productDao.countExtended();
    }
    public List<Product> getAllProducts(){
        logger.info("receiving data from database ...");
        return productDao.findAll();
    }
}
