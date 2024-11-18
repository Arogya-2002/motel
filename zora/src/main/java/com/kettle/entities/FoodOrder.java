package com.kettle.entities;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class FoodOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToMany
    @JoinTable(
        name = "food_order_items",
        joinColumns = @JoinColumn(name = "food_order_id"),
        inverseJoinColumns = @JoinColumn(name = "food_id")
    )
    private List<Food> orderedFoods; 

	private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    // Date and time of the order, optional
    private LocalDateTime orderDateTime;
    
    private Double totalAmount; 

    // Getters and setters
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDateTime getOrderDateTime() {
        return orderDateTime;
    }

    public void setOrderDateTime(LocalDateTime orderDateTime) {
        this.orderDateTime = orderDateTime;
    }

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
		
		
	}
    public List<Food> getOrderedFoods() {
		return orderedFoods;
	}

	public void setOrderedFoods(List<Food> orderedFoods) {
		this.orderedFoods = orderedFoods;
	}

	public FoodOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FoodOrder(Long orderId, Room room, List<Food> orderedFoods, Integer quantity, Customer customer,
			LocalDateTime orderDateTime, Double totalAmount) {
		super();
		this.orderId = orderId;
		this.room = room;
		this.orderedFoods = orderedFoods;
		this.quantity = quantity;
		this.customer = customer;
		this.orderDateTime = orderDateTime;
		this.totalAmount = totalAmount;
	}
	
	
	
}


