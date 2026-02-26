package com.fintech.test;

import com.fintech.entity.*;
import com.fintech.service.BankingService;
import com.fintech.util.JPAUtil;
import jakarta.persistence.*;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class DepositTest {

    private EntityManager em;
    private EntityTransaction tx;
    private BankingService service = new BankingService();

    private Long accountId;

    @BeforeEach
    void setUp() {

        em = JPAUtil.getEntityManager();
        tx = em.getTransaction();

        tx.begin();

        Customer c = new Customer();
        c.setName("Deposit Test");

        BankAccount acc = new BankAccount();
        acc.setAccountNumber("DEP100");
        acc.setBalance(BigDecimal.valueOf(1000));

        c.addAccount(acc);

        em.persist(c);
        accountId = acc.getId();

        tx.commit();
        em.close();
    }

    @Test
    void testDepositIncreasesBalance() {

        service.deposit(accountId, BigDecimal.valueOf(500));

        EntityManager em2 = JPAUtil.getEntityManager();
        BankAccount updated = em2.find(BankAccount.class, accountId);

        assertEquals(1500, updated.getBalance().intValue());
        em2.close();
    }
}