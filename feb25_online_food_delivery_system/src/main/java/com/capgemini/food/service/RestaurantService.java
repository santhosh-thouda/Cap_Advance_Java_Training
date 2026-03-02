package com.capgemini.food.service;

import org.springframework.stereotype.Service;

@Service
public class RestaurantService {

    public void prepareFood(String item, int quantity) {
        System.out.println("Restaurant preparing " + quantity + " " + item);
    }
}