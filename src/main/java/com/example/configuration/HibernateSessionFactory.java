package com.example.configuration;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            synchronized (HibernateSessionFactory.class) {
                if (sessionFactory == null) {
                    Configuration configuration = new Configuration();
                    sessionFactory = configuration.configure().buildSessionFactory();
                }
            }
        }
        return sessionFactory;
    }

}
