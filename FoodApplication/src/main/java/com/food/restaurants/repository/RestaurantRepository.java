package com.food.restaurants.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food.restaurants.entity.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
	

}
