package com.fintech.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phone;

    // 1 Customer → Many Accounts
    @OneToMany(mappedBy = "customer",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    private List<BankAccount> accounts = new ArrayList<>();

    // Helper Method
    public void addAccount(BankAccount account) {
        accounts.add(account);
        account.setCustomer(this);
    }

    public void removeAccount(BankAccount account) {
        accounts.remove(account);
        account.setCustomer(null);
    }

    // Getters & Setters
    public Long getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public List<BankAccount> getAccounts() { return accounts; }
}