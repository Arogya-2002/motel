package com.kettle.services;

import java.util.List;

import com.kettle.entities.Hotel;
import com.kettle.entities.Room;

import dtos.HotelDto;

public interface AdminService {
	 public Hotel addHotelWithRooms(HotelDto hotelDto);
	 public Hotel enableHotel(Long hotelId);
	 public Hotel disableHotel(Long hotelId);
	 public List<Hotel> getAllEnabledHotels();

}
