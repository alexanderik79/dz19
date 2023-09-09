package org.example.service.daointerfaces;

import org.example.entity.Order;

import java.util.List;

public interface OrderDao {
    void save (Order order);
    Order getById (int id);
    List<Order> findAll();
    void updateById (int id);
}
