package com.food.restaurants.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food.restaurants.entity.OrderDetails;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer> {

	//OrderDetails findById(Long orderId);

	Optional<OrderDetails> findByOrdersId(Long ordersId);

}
