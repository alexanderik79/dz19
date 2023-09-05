package org.example.service;

import org.example.entity.Product;
import org.example.entity.User;
import org.example.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import java.math.BigDecimal;
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
        List products = session.createQuery("FROM Product").getResultList();
        session.close();
        return products;
    }

    @Override
    public void updateById(int id) {
        final Session session = factory.openSession();
        Transaction t = session.beginTransaction();
        Query query = session.createQuery("update Product set price= :correctPrice where id= :id");
        query.setParameter("correctPrice", new BigDecimal(333.30));
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

    public void countExtended(){
        final Session session = factory.openSession();
        String hql =
                "SELECT c.nname, o.nname, o.totalSum, COUNT(p.id) " +
                        "FROM Customer c " +
                        "LEFT JOIN c.orders o " +
                        "INNER JOIN o.orderProducts op " +
                        "INNER JOIN op.product p " +
                        "GROUP BY c.nname, o.nname, o.totalSum";

        Query query = session.createQuery(hql);
        List<Object[]> results = query.list();

        for (Object[] result : results) {
            String customerName = (String) result[0];
            String orderName = (String) result[1];
            BigDecimal sum = new BigDecimal(String.valueOf(result[2]));
            Long orderCount = (Long) result[3];

            System.out.println("Имя клиента: " + customerName + ", Номер заказа: " + orderName +
                    ", Сумма: " + sum + ", Кол. заказов: " + orderCount);
        }
    }
}
