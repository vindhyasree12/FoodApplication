package com.food.restaurants.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity

@Table(name = "item")
public class Item {
	
	@Id
	@Column(name = "item_id")
	@GeneratedValue
	private Long itemId;
	@Column(name = "item_name")
	private String itemName;
	private int price;
	
	@ManyToOne(
			cascade = CascadeType.ALL
			)
	@JoinColumn(
			//name = "restaurant_id",
			referencedColumnName = "restaurantId"
			)
	Restaurant restaurant;
	
	@ManyToMany(targetEntity = Orders.class)
	private List<Orders> orders;

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}


	
	
	
}
