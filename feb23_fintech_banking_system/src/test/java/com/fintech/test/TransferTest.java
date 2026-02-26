package com.fintech.test;

import com.fintech.entity.*;
import com.fintech.service.BankingService;
import com.fintech.util.JPAUtil;
import jakarta.persistence.*;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class TransferTest {

    private BankingService service = new BankingService();
    private Long acc1Id;
    private Long acc2Id;

    @BeforeEach
    void setUp() {

        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        Customer c1 = new Customer();
        BankAccount a1 = new BankAccount();
        a1.setAccountNumber("T100");
        a1.setBalance(BigDecimal.valueOf(2000));
        c1.addAccount(a1);

        Customer c2 = new Customer();
        BankAccount a2 = new BankAccount();
        a2.setAccountNumber("T200");
        a2.setBalance(BigDecimal.valueOf(1000));
        c2.addAccount(a2);

        em.persist(c1);
        em.persist(c2);

        acc1Id = a1.getId();
        acc2Id = a2.getId();

        tx.commit();
        em.close();
    }

    @Test
    void testTransfer() {

        service.transfer(acc1Id, acc2Id, BigDecimal.valueOf(500));

        EntityManager em = JPAUtil.getEntityManager();

        BankAccount a1 = em.find(BankAccount.class, acc1Id);
        BankAccount a2 = em.find(BankAccount.class, acc2Id);

        assertEquals(1500, a1.getBalance().intValue());
        assertEquals(1500, a2.getBalance().intValue());

        em.close();
    }
}