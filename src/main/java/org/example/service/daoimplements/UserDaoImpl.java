package org.example.service.daoimplements;

import org.example.entity.User;
import org.example.service.daointerfaces.UserDao;
import org.example.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class UserDaoImpl implements UserDao {
    final SessionFactory factory = HibernateUtils.getSessionFactory();
    @Override
    public void save(User user) {
        final Session session = factory.openSession();
        final Transaction t = session.beginTransaction();
        session.save(user);
        t.commit();
        session.close();
    }

    @Override
    public User getUserById(int id) {
        return null;
    }

    @Override
    public List<User> findAll() {
       return null;
    }
}
