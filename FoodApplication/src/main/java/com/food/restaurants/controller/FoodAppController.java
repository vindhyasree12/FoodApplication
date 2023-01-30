package com.food.restaurants.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.food.restaurants.entity.Item;
import com.food.restaurants.entity.OrderContent;
import com.food.restaurants.entity.OrderDetails;
import com.food.restaurants.entity.Orders;
import com.food.restaurants.entity.Restaurant;
import com.food.restaurants.service.RestaurantService;

@RestController
public class FoodAppController {
	@Autowired
	RestaurantService service;
	@PostMapping("/saveRestaurant")
	public String saveRestaurant(@RequestBody Restaurant restaurant) {
		service.saveRestaurant(restaurant);
		return "Restaurant insertion Successful";
	}
	
	@GetMapping("/getRestaurants")
	public List<Restaurant> getRestaurants(){
		return service.getRestaurants();
	}
	
	@PostMapping("/saveItem")
	public String saveItem(@RequestBody Item item) {
		service.saveItem(item);
		System.out.println(item.toString());
		return "Item insertion successful";	
	}
	@GetMapping("/getItemsList")
	public Optional<Item> getItemsList(Long restaurantId){
		return service.getItemsList(restaurantId);
	}
	
	@GetMapping("/getPrice")
	public int getPrice(@RequestParam long itemId) {
		return service.getPrice(itemId);
	}
	
	@PostMapping("/saveOrder")
	public String saveOrder(@RequestBody OrderContent orderContent) {
		service.saveOrder(orderContent);
		return "Order insertion successful";
	}
	@GetMapping("/getOrderDetails")
	public Optional<OrderDetails> getOrderDetails(@RequestParam long ordersId) {
		
		return service.getOrderDetails(ordersId);
		
	}

}
