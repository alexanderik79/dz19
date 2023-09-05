package org.example.service;

import org.example.entity.Product;
import org.example.entity.User;
import org.example.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import java.util.List;

public class ProductDaoImpl implements ProductDao{
    final SessionFactory factory = HibernateUtils.getSessionFactory();
    @Override
    public void save(Product product) {
        final Session session = factory.openSession();
        final Transaction t = session.beginTransaction();
        session.save(product);
        t.commit();
        session.close();
    }

    @Override
    public Product getById(int id) {
        return null;
    }

    @Override
    public List<Product> findAll() {
        final Session session = factory.openSession();
        List products = session.createQuery("FROM Products").getResultList();
        session.close();
        return products;
    }

    @Override
    public void updateById(int id) {
        final Session session = factory.openSession();
        Transaction t = session.beginTransaction();
        Query query = session.createQuery("update Products set price=:correctPrice where id=:id");
        query.setParameter("correctPrice", 333.30);
        query.setParameter("id", id);
        query.executeUpdate();
        t.commit();
        session.clear();
        session.close();
    }
    public void countOrders(){
        final Session session = factory.openSession();
        String hql =
                "SELECT c.nname, COUNT(o.id) " +
                "FROM Customer c " +
                "LEFT JOIN c.orders o " +
                "GROUP BY c.nname";

        Query query = session.createQuery(hql);
        List<Object[]> results = query.list();

        for (Object[] result : results) {
            String customerName = (String) result[0];
            Long orderCount = (Long) result[1];

            System.out.println("Имя клиента: " + customerName + ", Количество заказов: " + orderCount);
        }
    }
}
