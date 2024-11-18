package com.kettle.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Room {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomId;  // Unique identifier for each room

    private String roomType;
    private Double Price;
    private boolean availability;  // Availability of the room (true or false)
    
    @ManyToOne
    @JoinColumn(name ="hotel_id")
    private Hotel hotel;
    
    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<FoodOrder> foodOrders;

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getRoomId() {
		return roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}

	public boolean isAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public Double getPrice() {
		return Price;
	}

	public void setPrice(Double price) {
		Price = price;
	}

	
	public Room(Long roomId, String roomType, Double price, boolean availability, Hotel hotel) {
		super();
		this.roomId = roomId;
		this.roomType = roomType;
		Price = price;
		this.availability = availability;
		this.hotel = hotel;
	}


	
}

