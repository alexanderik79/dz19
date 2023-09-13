package org.example.service.daoimplements;


import org.example.entity.Customer;
import org.example.entity.Order;
import org.example.entity.Product;
import org.example.service.daointerfaces.ProductDao;
import org.example.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import java.math.BigDecimal;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
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

            System.out.println("Ім'я клієнта: " + customerName + ", Кількість замовлень: " + orderCount);
        }
    }
    public List<Customer> countOrders2(){
        final Session session = factory.openSession();
        String hql = "FROM Customer";
        List results = session.createQuery(hql).getResultList();
        session.close();
        return results;
    }

    public void countExtended() {
        final Session session = factory.openSession();
        String hql =
                "SELECT c.nname, c.surnname, o.nname, o.totalSum, COUNT(p.id) " +
                        "FROM Customer c " +
                        "LEFT JOIN c.orders o " +
                        "INNER JOIN o.products p " +
                        "GROUP BY c.nname, c.surnname, o.nname, o.totalSum";

        Query query = session.createQuery(hql);
        List<Object[]> results = query.list();

        for (Object[] result : results) {
            String customerName = (String) result[0];
            String customerSurnName = (String) result[1];
            String orderName = (String) result[2];
            BigDecimal sum = new BigDecimal(String.valueOf(result[3]));
            Long prodCount = (Long) result[4];

            System.out.println("Ім'я клієнта: " + customerName + ", Прізвище клієнта: "
                    +customerSurnName+ ", Номер замовлення: " + orderName +
                    ", Сума: " + sum + ", Кількість продуктів: " + prodCount);
        }
    }
    public List<Order> countExtended2() {
        final Session session = factory.openSession();
        String hql = "SELECT o FROM Order o LEFT JOIN FETCH o.products";
        List results = session.createQuery(hql).getResultList();
        session.close();
        return results;
    }
}
