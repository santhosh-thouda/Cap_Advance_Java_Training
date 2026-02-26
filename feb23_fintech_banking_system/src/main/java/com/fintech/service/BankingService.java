package com.fintech.service;

import com.fintech.dao.*;
import com.fintech.entity.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class BankingService {

    private CustomerDAO customerDAO = new CustomerDAO();
    private BankAccountDAO accountDAO = new BankAccountDAO();

    // -------------------------------------------------
    // Create Customer with Bank Account
    // -------------------------------------------------
    public void createCustomerWithAccount(String name,
                                          String email,
                                          String phone,
                                          String accountNumber,
                                          BigDecimal initialBalance) {

        Customer customer = new Customer();
        customer.setName(name);
        customer.setEmail(email);
        customer.setPhone(phone);

        BankAccount account = new BankAccount();
        account.setAccountNumber(accountNumber);
        account.setBalance(initialBalance);

        // Relationship
        customer.addAccount(account);

        customerDAO.save(customer);

        System.out.println("Customer + Account created successfully");
    }

    // -------------------------------------------------
    // Deposit Money
    // -------------------------------------------------
    public void deposit(Long accountId, BigDecimal amount) {

        BankAccount account = accountDAO.findById(accountId);

        if (account == null) {
            System.out.println("Account not found");
            return;
        }

        account.setBalance(account.getBalance().add(amount));

        Transaction txn = new Transaction();
        txn.setAmount(amount);
        txn.setType("DEPOSIT");
        txn.setTransactionDate(LocalDateTime.now());

        account.getTransactions().add(txn);

        accountDAO.update(account);

        System.out.println("Deposit successful");
    }

    // -------------------------------------------------
    // Withdraw Money
    // -------------------------------------------------
    public void withdraw(Long accountId, BigDecimal amount) {

        BankAccount account = accountDAO.findById(accountId);

        if (account == null) {
            System.out.println("Account not found");
            return;
        }

        if (account.getBalance().compareTo(amount) < 0) {
            System.out.println("Insufficient balance");
            return;
        }

        account.setBalance(account.getBalance().subtract(amount));

        Transaction txn = new Transaction();
        txn.setAmount(amount);
        txn.setType("WITHDRAW");
        txn.setTransactionDate(LocalDateTime.now());

        account.getTransactions().add(txn);

        accountDAO.update(account);

        System.out.println("Withdrawal successful");
    }

    // -------------------------------------------------
    // Transfer Money
    // -------------------------------------------------
    public void transfer(Long fromId, Long toId, BigDecimal amount) {

        BankAccount from = accountDAO.findById(fromId);
        BankAccount to = accountDAO.findById(toId);

        if (from == null || to == null) {
            System.out.println("Invalid accounts");
            return;
        }

        if (from.getBalance().compareTo(amount) < 0) {
            System.out.println("Insufficient balance");
            return;
        }

        from.setBalance(from.getBalance().subtract(amount));
        to.setBalance(to.getBalance().add(amount));

        Transaction txn = new Transaction();
        txn.setAmount(amount);
        txn.setType("TRANSFER");
        txn.setTransactionDate(LocalDateTime.now());

        from.getTransactions().add(txn);

        accountDAO.update(from);
        accountDAO.update(to);

        System.out.println("Transfer successful");
    }

    // -------------------------------------------------
    // Issue Card
    // -------------------------------------------------
    public void issueCard(Long accountId,
                          String cardNumber,
                          String type) {

        BankAccount account = accountDAO.findById(accountId);

        if (account == null) {
            System.out.println("Account not found");
            return;
        }

        Card card = new Card();
        card.setCardNumber(cardNumber);
        card.setCardType(type);
        card.setExpiryDate(LocalDate.now().plusYears(5));

        account.setCard(card);

        accountDAO.update(account);

        System.out.println("Card issued successfully");
    }

    // -------------------------------------------------
    // View Account Balance
    // -------------------------------------------------
    public void checkBalance(Long accountId) {

        BankAccount account = accountDAO.findById(accountId);

        if (account == null) {
            System.out.println("Account not found");
            return;
        }

        System.out.println("Current Balance: " + account.getBalance());
    }
}