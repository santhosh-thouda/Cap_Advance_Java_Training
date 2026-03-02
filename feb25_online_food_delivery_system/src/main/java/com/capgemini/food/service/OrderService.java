package com.capgemini.food.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private DeliveryService deliveryService;

    @Autowired
    private NotificationService notificationService;

    public void placeOrder(String item, int quantity) {

        System.out.println("\nPlacing order...");
        restaurantService.prepareFood(item, quantity);
        deliveryService.deliverOrder(item);
        notificationService.sendNotification("Your order for " + item + " is on the way!");
    }
}