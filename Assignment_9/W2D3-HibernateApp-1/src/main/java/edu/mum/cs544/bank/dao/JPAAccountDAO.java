package edu.mum.cs544.bank.dao;

import java.util.*;

import edu.mum.cs544.bank.domain.Account;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class JPAAccountDAO implements IJPAAccountDAO {

    @Override
    public void saveAccount(Account account) {
        EntityManager em = EntityManagerHelper.getCurrent();
        // System.out.println("AccountDAO: saving account with accountnr ="+account.getAccountnumber());
        em.getTransaction().begin();
        em.persist(account.getCustomer());
        em.persist(account); // add the new
        em.getTransaction().commit();
    }

    @Override
    public void updateAccount(Account account) {
        // System.out.println("AccountDAO: update account with accountnr ="+account.getAccountnumber());
        EntityManager em = EntityManagerHelper.getCurrent();
        em.getTransaction().begin();
        em.merge(account);
        em.getTransaction().commit();

    }

    @Override
    public Account loadAccount(long accountnumber) {
        // System.out.println("AccountDAO: loading account with accountnr ="+accountnumber);
        EntityManager em = EntityManagerHelper.getCurrent();
        TypedQuery<Account> query = em.createQuery("from Account a where a.accountnumber = :accountnumber", Account.class);
        query.setParameter("accountnumber", accountnumber);
        return query.getSingleResult();
//        return em.find(Account.class, accountnumber);

    }

    @Override
    public Collection<Account> getAccounts() {
        EntityManager em = EntityManagerHelper.getCurrent();
        TypedQuery<Account> query = em.createQuery("from Account", Account.class);
        return query.getResultList();
    }

}
