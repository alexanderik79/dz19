package org.example.service;

import org.example.entity.Order;
import org.example.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class OrderDaoImpl implements OrderDao{
    final SessionFactory factory = HibernateUtils.getSessionFactory();
    @Override
    public void save(Order order) {
        final Session session = factory.openSession();
        final Transaction t = session.beginTransaction();
        session.save(order);
        t.commit();
        session.close();
    }

    @Override
    public Order getById(int id) {
        return null;
    }

    @Override
    public List<Order> findAll() {
        return null;
    }

    @Override
    public void updateById(int id) {

    }
}
