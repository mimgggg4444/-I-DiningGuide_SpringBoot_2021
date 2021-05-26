package com.kwssis.kws.domain;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class RestaurantTests {

    @Test
    public void creation() {
        Restaurant restaurant = new Restaurant("Bob zip", "Seoul");

        assertThat(restaurant.getName(), is("Bob zip"));    // 원래 안됐는데 hamcrest 라이브러리 설치하고 도 안됐는데 assertThat를 hamcrest로 가져오니까 됨.
        assertThat(restaurant.getAddress(), is("Seoul"));

    }

    @Test
    public void information(){
        Restaurant restaurant = new Restaurant("Bob zip", "Seoul");
        assertThat(restaurant.getInformation(), is("Bob zip in Seoul"));
    }
}