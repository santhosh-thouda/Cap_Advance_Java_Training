package com.capgemini.food;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.capgemini.food.config.FoodAppConfig;
import com.capgemini.food.service.OrderService;

public class Main {

    public static void main(String[] args) {

        System.out.println("===== ONLINE FOOD DELIVERY SYSTEM =====\n");

        ApplicationContext context =
                new AnnotationConfigApplicationContext(FoodAppConfig.class);

        OrderService orderService = context.getBean(OrderService.class);

        orderService.placeOrder("Pizza", 2);
        orderService.placeOrder("Burger", 1);

        ((AnnotationConfigApplicationContext) context).close();

        System.out.println("\n===== APPLICATION CLOSED =====");
    }
}