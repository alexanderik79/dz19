package org.example.service;

import org.example.entity.Customer;
import org.example.entity.OrderDetails;

import java.util.List;

public class OrderDetailsService {
    private final OrderDetailsDaoImpl orderDetailsDao = new OrderDetailsDaoImpl();
    public void save (OrderDetails orderDetails){
        orderDetailsDao.save(orderDetails);
    }
    public List<OrderDetails> getAll(){
        return orderDetailsDao.findAll();
    }
}
