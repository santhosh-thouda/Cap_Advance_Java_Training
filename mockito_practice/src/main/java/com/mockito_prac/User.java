package com.mockito_prac;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class User {

	@Id
	private int id;

    private String name;

    private double balance;
    
    
    
    public User() {}

    public User(int id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }
	
}