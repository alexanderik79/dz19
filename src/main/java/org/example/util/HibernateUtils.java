package org.example.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.entity.*;
import org.example.service.UserService;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtils {
    private static SessionFactory sessionFactory;
    static Logger logger = LogManager.getLogger(UserService.class);

    public static SessionFactory getSessionFactory(){
        if (sessionFactory == null) {
            try {
                logger.warn("Start building session factory");
                sessionFactory = new Configuration().addAnnotatedClass(User.class)
                        .addAnnotatedClass(Customer.class)
                        .addAnnotatedClass(Order.class)
                        .addAnnotatedClass(OrderDetails.class)
                        .addAnnotatedClass(Product.class)
//                        .addAnnotatedClass(Test.class)
                        .buildSessionFactory();
            } catch (Exception e) {
                logger.error("ERROR building session factory!!!");
                System.out.println(e.getMessage());
            }
        }
        return sessionFactory;
    }
}
