package org.example.service;

import org.example.entity.Order;
import org.example.entity.OrderDetails;
import org.example.entity.Product;
import org.example.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class OrderDetailsDaoImpl implements OrderDetailsDao{
    final SessionFactory factory = HibernateUtils.getSessionFactory();
    @Override
    public List<OrderDetails> findAll() {
        final Session session = factory.openSession();
        List orderDetails = session.createQuery("FROM OrderDetails ORDER BY timePlaced").getResultList();
        session.close();
        return orderDetails;
    }

    @Override
    public void save(OrderDetails orderDetails) {
        final Session session = factory.openSession();
        final Transaction t = session.beginTransaction();
        session.save(orderDetails);
        t.commit();
        session.close();
    }
    @Override
    public Order getById(int id) {
        return null;
    }

    @Override
    public void updateById(int id) {

    }
}
