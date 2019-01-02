package com.example.repositories;

import com.example.configuration.HibernateSessionFactory;
import com.example.entities.db.Account;
import com.example.exceptions.AccountNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Optional;

import static org.hibernate.LockMode.OPTIMISTIC;

public class AccountRepository {

    private SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
    private Session session;
    private Transaction transaction;

    public Account findByIdAndLock(long id) throws AccountNotFoundException {
        if (session == null || !session.isOpen()) {
            session = sessionFactory.openSession();
        }

        if (transaction == null || !transaction.isActive()) {
            transaction = session.beginTransaction();
        }

        return Optional.ofNullable(session.get(Account.class, id, OPTIMISTIC))
                .orElseThrow(() -> new AccountNotFoundException(id));
    }

    public void commit() {
        if (transaction != null) {
            transaction.commit();
        }
    }

    public void closeSession() {
        if (session != null) {
            session.close();
        }
    }
}
