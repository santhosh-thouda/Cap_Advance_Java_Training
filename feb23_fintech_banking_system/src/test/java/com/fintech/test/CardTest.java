package com.fintech.test;

import com.fintech.entity.*;
import com.fintech.service.BankingService;
import com.fintech.util.JPAUtil;
import jakarta.persistence.*;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class CardTest {

    private BankingService service = new BankingService();
    private Long accountId;

    @BeforeEach
    void setUp() {

        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        Customer c = new Customer();
        BankAccount acc = new BankAccount();
        acc.setAccountNumber("CARD100");
        acc.setBalance(BigDecimal.valueOf(1000));

        c.addAccount(acc);
        em.persist(c);

        accountId = acc.getId();

        tx.commit();
        em.close();
    }

    @Test
    void testIssueCard() {

        service.issueCard(accountId, "1111222233334444", "DEBIT");

        EntityManager em = JPAUtil.getEntityManager();
        BankAccount acc = em.find(BankAccount.class, accountId);

        assertNotNull(acc.getCard());
        em.close();
    }
}