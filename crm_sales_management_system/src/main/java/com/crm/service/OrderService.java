package com.crm.service;

import com.crm.entity.*;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

public class OrderService {

    private EntityManager em;

    public OrderService(EntityManager em) {
        this.em = em;
    }

    public void placeOrder(Long customerId, List<Long> productIds) {

        EntityTransaction et = em.getTransaction();

        try {
            et.begin();

            Customer customer = em.find(Customer.class, customerId);

            Order order = new Order();
            order.setOrderDate(LocalDate.now());
            order.setCustomer(customer);

            List<Product> products =
                    em.createQuery("SELECT p FROM Product p WHERE p.id IN :ids",
                            Product.class)
                      .setParameter("ids", productIds)
                      .getResultList();

            double total = products.stream()
                                   .mapToDouble(Product::getPrice)
                                   .sum();

            order.setProducts(products);
            order.setTotalAmount(total);

            em.persist(order);

            et.commit();
            System.out.println("Order Placed Successfully");

        } catch (Exception e) {
            et.rollback();
        }
    }
}