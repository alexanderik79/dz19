package org.example.service;

import org.example.entity.Order;
import org.example.entity.OrderDetails;

import java.util.List;

public interface OrderDetailsDao {
    List<OrderDetails> findAll();
    void save (OrderDetails orderDetails);
    Order getById (int id);

    void updateById (int id);
}
