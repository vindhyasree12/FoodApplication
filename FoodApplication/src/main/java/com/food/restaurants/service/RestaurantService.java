package com.food.restaurants.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.restaurants.entity.Item;
import com.food.restaurants.entity.OrderContent;
import com.food.restaurants.entity.OrderDetails;
import com.food.restaurants.entity.Orders;
import com.food.restaurants.entity.Restaurant;
import com.food.restaurants.repository.ItemRepository;
import com.food.restaurants.repository.OrderDetailsRepository;
import com.food.restaurants.repository.OrderRepository;
import com.food.restaurants.repository.RestaurantRepository;
@Service
public class RestaurantService {
	@Autowired
	RestaurantRepository restaurantRepository;
	@Autowired
	ItemRepository itemRepository;
	@Autowired
	OrderRepository orderRepository;
	@Autowired
	OrderDetailsRepository orderDetailsRepository;
	public void saveRestaurant(Restaurant restaurant) {
		restaurantRepository.save(restaurant);
		
	}

	public List<Restaurant> getRestaurants() {
		
		return restaurantRepository.findAll();
	}

	public void saveItem(Item item) {
		itemRepository.save(item);
		
	}

	public Optional<Item> getItemsList(Long restaurantId) {
				return itemRepository.findById(restaurantId);
	}

	public int getPrice(Long itemId) {
		return itemRepository.findPriceByItemId(itemId).getPrice();
	}

	public void saveOrder(OrderContent orderContent) {
		Orders order = new Orders();
		order.setOrderDate(orderContent.getOrderDate());
		order.setOrderId(orderContent.getOrderId());
		OrderDetails ods = new OrderDetails();
		orderRepository.save(order);
		ods.setOrdersId(order.getOrderId());
		for(Item item : orderContent.getItems()) {
			ods.setItemsId(item.getItemId());
			
		}
		orderDetailsRepository.save(ods);
		 
		
	}

	public Optional<OrderDetails> getOrderDetails(Long ordersId) {
		
		return orderDetailsRepository.findByOrdersId(ordersId);
	}
	
	
	

}