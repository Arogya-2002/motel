package com.kettle.services;

import java.util.List;

import com.kettle.entities.Hotel;
import com.kettle.entities.Room;

public interface AdminService {
	 public Hotel addHotel(Hotel hotel,Room room);
	 public Hotel enableHotel(Long hotelId);
	 public Hotel disableHotel(Long hotelId);
	 public List<Hotel> getAllEnabledHotels();

}
