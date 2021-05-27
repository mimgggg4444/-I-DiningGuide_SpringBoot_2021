package com.kwssis.kws.domain;

import java.util.ArrayList;
import java.util.List;

public class RestaurantRepository {
    private List<Restaurant> restaurants = new ArrayList<>();
    public RestaurantRepository(){
        restaurants.add(new Restaurant(1L, "Bob zip", "seoul"));
        restaurants.add(new Restaurant(2L, "Cyber Food", "seoul"));
    }
    public List<Restaurant> findAll() {
        return restaurants;
    }
    public Restaurant findById(Long id) {
         return restaurants.stream()
                .filter(r -> r.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
