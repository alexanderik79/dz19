package org.example.service.daointerfaces;

import org.example.entity.Order;
import org.example.entity.OrderDetails;

import java.util.List;

public interface OrderDetailsDao {
    List<OrderDetails> findAll();
    void save (OrderDetails orderDetails);
}
