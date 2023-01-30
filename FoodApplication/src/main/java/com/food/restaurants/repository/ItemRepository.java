package com.food.restaurants.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food.restaurants.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

	Item findPriceByItemId(Long itemId);

	

	//Optional<Item> findByRestaurntId(Long restaurantId);

}
