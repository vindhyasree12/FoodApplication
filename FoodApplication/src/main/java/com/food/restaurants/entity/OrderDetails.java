package com.food.restaurants.entity;

import java.util.List;
import javax.persistence.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
@Entity
public class OrderDetails {
	
	@Id
	@GeneratedValue
	private int sNo;
	private long itemsId;
	private long ordersId;

	@ManyToMany(
            cascade = CascadeType.ALL
    )
    @JoinTable(
            
            joinColumns = @JoinColumn(
                    name = "ordersId"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "itemsId"
            )
    )
	private List<Item> items;

	public int getsNo() {
		return sNo;
	}

	public void setsNo(int sNo) {
		this.sNo = sNo;
	}

	public long getItemsId() {
		return itemsId;
	}

	public void setItemsId(long itemsId) {
		this.itemsId = itemsId;
	}

	public long getOrdersId() {
		return ordersId;
	}

	public void setOrdersId(long ordersId) {
		this.ordersId = ordersId;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	

}
