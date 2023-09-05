package org.example.service;

import org.example.entity.Customer;
import org.example.entity.Product;
import org.example.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class CustomerDaoImpl implements CustomerDao{
    final SessionFactory factory = HibernateUtils.getSessionFactory();
    @Override
    public void save(Customer customer) {
        final Session session = factory.openSession();
        final Transaction t = session.beginTransaction();
        session.save(customer);
        t.commit();
        session.close();
    }

    @Override
    public Customer getById(int id) {
        return null;
    }

    @Override
    public List<Customer> findAll() {
        return null;
    }

    @Override
    public void updateById(int id) {

    }
}
