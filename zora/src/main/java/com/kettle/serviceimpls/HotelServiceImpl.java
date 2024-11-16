package com.kettle.serviceimpls;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kettle.entities.Hotel;
import com.kettle.entities.Room;
import com.kettle.repositories.HotelRepository;
import com.kettle.repositories.RoomRepository;
import com.kettle.services.HotelService;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelRepository hotelRepository;
	
	private RoomRepository roomRepository;
	@Override
	public Hotel addFoodItem(Long hotelId, HashMap<String, Double> foodItem) {
		 Hotel hotel = hotelRepository.findById(hotelId)
	                .orElseThrow(() -> new RuntimeException("Hotel not found"));
	        hotelRepository.getById(hotelId).getMenuItems().putAll(foodItem);
	        return hotelRepository.save(hotel);
	}

	@Override
	public HashMap getMenuItems(Long hotelId) {
		Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new RuntimeException("Hotel not found"));
		return hotelRepository.getById(hotelId).getMenuItems();
		
	
	}


	@Override
	public Hotel removeFoodItem(Long hotelId, String foodItem) {
		 Hotel hotel = hotelRepository.findById(hotelId)
	                .orElseThrow(() -> new RuntimeException("Hotel not found"));
		hotelRepository.getById(hotelId).getMenuItems().remove(foodItem);
		return  hotelRepository.save(hotel);
	}

}
