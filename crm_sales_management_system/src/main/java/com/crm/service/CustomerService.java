package com.crm.service;

import com.crm.entity.*;
import javax.persistence.*;

public class CustomerService {

    private EntityManager em;

    public CustomerService(EntityManager em) {
        this.em = em;
    }

    public void registerCustomer(String name, String email, String phone) {

        EntityTransaction et = em.getTransaction();

        try {
            et.begin();

            Customer customer = new Customer();
            customer.setName(name);
            customer.setEmail(email);
            customer.setPhone(phone);

            em.persist(customer);

            et.commit();
            System.out.println("Customer Registered Successfully");

        } catch (Exception e) {
            et.rollback();
        }
    }

    public void addAddressToCustomer(Long customerId, Address address) {

        EntityTransaction et = em.getTransaction();

        try {
            et.begin();

            Customer customer = em.find(Customer.class, customerId);

            if (customer != null) {
                customer.setAddress(address);
                em.persist(address);
            }

            et.commit();
            System.out.println("Address Added Successfully");

        } catch (Exception e) {
            et.rollback();
        }
    }
}