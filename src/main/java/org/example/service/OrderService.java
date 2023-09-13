package org.example.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.entity.Order;
import org.example.service.daoimplements.OrderDaoImpl;

public class OrderService {
    private final OrderDaoImpl orderDao = new OrderDaoImpl();
    Logger logger = LogManager.getLogger(OrderService.class);
    public void save (Order order){

        if(order == null){
            logger.error("order is NULL!!!");
        }
        else {
            logger.warn("Start saving " + order.getNname() + ".");
            orderDao.save(order);
            logger.info(order.getNname() + " was saved.");
        }
    }
}
