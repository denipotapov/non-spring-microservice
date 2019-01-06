package com.example.configuration;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateEntityManagerFactory {

    private static EntityManagerFactory entityManagerFactory;

    public static void configureManagerFactory() {
        if (entityManagerFactory == null) {
            synchronized (HibernateEntityManagerFactory.class) {
                if (entityManagerFactory == null) {
                    entityManagerFactory = Persistence.createEntityManagerFactory("moneyTransfer");
                }
            }
        }
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

}
