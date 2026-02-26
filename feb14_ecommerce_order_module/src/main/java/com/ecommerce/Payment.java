package com.ecommerce;

import javax.persistence.*;

@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mode;
    private double amount;

    @ManyToOne
    private PurchaseOrder order;

    public Long getId() { return id; }

    public String getMode() { return mode; }
    public void setMode(String mode) { this.mode = mode; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public PurchaseOrder getOrder() { return order; }
    public void setOrder(PurchaseOrder order) {
        this.order = order;
    }
}
