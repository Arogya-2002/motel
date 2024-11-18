package com.kettle.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Food {

	@Id
	private Long foodId;
	private String foodName;
	private Double price;
	
	@ManyToOne
	@JoinColumn(name="hotel_id")
	private Hotel hotel;

	public Long getFoodId() {
		return foodId;
	}

	public void setFoodId(Long foodId) {
		this.foodId = foodId;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Food() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Food(Long foodId, String foodName, Double price, Hotel hotel) {
		super();
		this.foodId = foodId;
		this.foodName = foodName;
		this.price = price;
		this.hotel = hotel;
	}
	
	
	
}
