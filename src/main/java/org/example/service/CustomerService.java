package org.example.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.entity.Customer;
import org.example.service.daoimplements.CustomerDaoImpl;

public class CustomerService {
    private final CustomerDaoImpl customerDao = new CustomerDaoImpl();
    Logger logger = LogManager.getLogger(CustomerService.class);
    public void save (Customer customer){
        if(customer == null){
            logger.error("order is NULL!!!");
        }
        else {
            logger.warn("Start saving order " + customer.getNname() + ".");
            customerDao.save(customer);
            logger.info("order " + customer.getNname() + " was saved.");
        }
    }
}
