package com.food.restaurants.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food.restaurants.entity.Orders;

public interface OrderRepository extends JpaRepository<Orders, Long> {

}
