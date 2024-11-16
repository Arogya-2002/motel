package com.kettle.entities;

import java.util.HashMap;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Room {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomId;  // Unique identifier for each room

    private HashMap<Long, String> roomType;  //roomid,roomtype
    private HashMap<String, Double> price;     // roomtype,price
    private boolean availability;  // Availability of the room (true or false)

    @ManyToOne
    @JoinColumn(name = "hotel_id")  // Many rooms can belong to one hotel
    private Hotel hotel;

	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Room(Long roomId, HashMap<Long, String> roomType, HashMap<String, Double> price, boolean availability,
			Hotel hotel) {
		super();
		this.roomId = roomId;
		this.roomType = roomType;
		this.price = price;
		this.availability = availability;
		this.hotel = hotel;
	}

	public Long getRoomId() {
		return roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}

	public HashMap<Long, String> getRoomType() {
		return roomType;
	}

	public void setRoomType(HashMap<Long, String> roomType) {
		this.roomType = roomType;
	}

	public HashMap<String, Double> getPrice() {
		return price;
	}

	public void setPrice(HashMap<String, Double> price) {
		this.price = price;
	}

	public boolean isAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	
	
}

