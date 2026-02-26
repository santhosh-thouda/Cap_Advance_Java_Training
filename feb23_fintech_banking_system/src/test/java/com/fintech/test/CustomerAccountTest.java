package com.fintech.test;

import com.fintech.entity.*;
import com.fintech.util.JPAUtil;
import jakarta.persistence.*;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerAccountTest {

    private EntityManager em;
    private EntityTransaction tx;

    @BeforeEach
    void setUp() {
        em = JPAUtil.getEntityManager();
        tx = em.getTransaction();
    }

    @AfterEach
    void tearDown() {
        if (tx.isActive()) tx.rollback();
        if (em.isOpen()) em.close();
    }

    @Test
    void testCustomerWithMultipleAccounts() {

        tx.begin();

        Customer customer = new Customer();
        customer.setName("Test User");

        BankAccount acc1 = new BankAccount();
        acc1.setAccountNumber("ACC101");
        acc1.setBalance(BigDecimal.valueOf(1000));

        BankAccount acc2 = new BankAccount();
        acc2.setAccountNumber("ACC102");
        acc2.setBalance(BigDecimal.valueOf(2000));

        customer.addAccount(acc1);
        customer.addAccount(acc2);

        em.persist(customer);
        Long id = customer.getId();
        tx.commit();

        em.clear();

        Customer loaded = em.find(Customer.class, id);
        assertEquals(2, loaded.getAccounts().size());
    }
}