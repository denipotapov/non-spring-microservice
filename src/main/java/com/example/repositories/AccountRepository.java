package com.example.repositories;

import com.example.configuration.HibernateEntityManagerFactory;
import com.example.entities.db.Account;
import com.example.exceptions.AccountNotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.Optional;

public class AccountRepository {

    private EntityManagerFactory entityManagerFactory = HibernateEntityManagerFactory.getEntityManagerFactory();
    private EntityManager entityManager;
    private EntityTransaction transaction;

    public Account findByIdAndLock(long id) throws AccountNotFoundException {
        if (entityManager == null || !entityManager.isOpen()) {
            entityManager = entityManagerFactory.createEntityManager();
        }

        if (transaction == null || !transaction.isActive()) {
            transaction = entityManager.getTransaction();
        }

        return Optional.ofNullable(entityManager.find(Account.class, id))
                .orElseThrow(() -> new AccountNotFoundException(id));
    }

    public void commit() {
        if (transaction != null) {
            transaction.commit();
        }
    }

    public void closeSession() {
        if (entityManager != null) {
            entityManager.close();
        }
    }

    public void rollback() {
        if (transaction != null) {
            transaction.rollback();
        }
    }
}
