package com.kwssis.kws.interfaces;


import com.kwssis.kws.domain.Restaurant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RestaurantController {

    @GetMapping("/restaurants")
    public List<Restaurant> list() {
        List<Restaurant> restaurants = new ArrayList<>();


        Restaurant restaurant = new Restaurant(1L,"Bob zip", "Seoul"); // Region names must be capitalized.
        restaurants.add(restaurant);

        return restaurants;
    }
}
