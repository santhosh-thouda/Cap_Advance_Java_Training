package com.fintech.test;

import com.fintech.entity.*;
import com.fintech.service.BankingService;
import com.fintech.util.JPAUtil;
import jakarta.persistence.*;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class WithdrawTest {

    private BankingService service = new BankingService();
    private Long accountId;

    @BeforeEach
    void setUp() {

        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        Customer c = new Customer();
        c.setName("Withdraw Test");

        BankAccount acc = new BankAccount();
        acc.setAccountNumber("WTH100");
        acc.setBalance(BigDecimal.valueOf(500));

        c.addAccount(acc);
        em.persist(c);

        accountId = acc.getId();
        tx.commit();
        em.close();
    }

    @Test
    void testWithdrawFailsIfInsufficientBalance() {

        service.withdraw(accountId, BigDecimal.valueOf(1000));

        EntityManager em = JPAUtil.getEntityManager();
        BankAccount acc = em.find(BankAccount.class, accountId);

        assertEquals(500, acc.getBalance().intValue());
        em.close();
    }
}