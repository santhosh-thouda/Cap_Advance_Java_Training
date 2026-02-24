package com.crm.service;

import com.crm.entity.Product;
import javax.persistence.*;

public class ProductService {

    private EntityManager em;

    public ProductService(EntityManager em) {
        this.em = em;
    }

    public void addProduct(String name, double price) {

        EntityTransaction et = em.getTransaction();

        try {
            et.begin();

            Product product = new Product();
            product.setName(name);
            product.setPrice(price);

            em.persist(product);

            et.commit();
            System.out.println("Product Added Successfully");

        } catch (Exception e) {
            et.rollback();
        }
    }
}