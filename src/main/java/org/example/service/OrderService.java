package org.example.service;

import org.example.entity.Order;
import org.example.service.daoimplements.OrderDaoImpl;

public class OrderService {
    private final OrderDaoImpl orderDao = new OrderDaoImpl();
    public void save (Order order){
        orderDao.save(order);
    }
}
