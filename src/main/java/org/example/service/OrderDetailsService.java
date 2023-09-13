package org.example.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.entity.OrderDetails;
import org.example.service.daoimplements.OrderDetailsDaoImpl;

import java.util.List;

public class OrderDetailsService {
    private final OrderDetailsDaoImpl orderDetailsDao = new OrderDetailsDaoImpl();
    Logger logger = LogManager.getLogger(OrderDetailsService.class);
    public void save (OrderDetails orderDetails){
        if(orderDetails == null){
            logger.error("order details is NULL!!!");
        }
        else {
            logger.warn("Start saving order details " + orderDetails.getOrder().getNname() + ".");
            orderDetailsDao.save(orderDetails);
            logger.info("order details" + orderDetails.getOrder().getNname() + " was saved.");
        }
    }
    public List<OrderDetails> getAll(){
        logger.info("receiving data from database ...");
        return orderDetailsDao.findAll();
    }
}
