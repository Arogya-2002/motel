package com.kettle.serviceimpls;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.kettle.entities.Hotel;
import com.kettle.services.HotelService;

@Service
public class HotelServiceImpl implements HotelService {

//	@Autowired
//	private HotelRepository hotelRepository;
//	
//	@Autowired
//	private RoomRepository roomRepository;

	@Override
	public Hotel addFoodItem(Long hotelId, HashMap<String, Double> foodItem) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hotel removeFoodItem(Long hotelId, String foodItem) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<Long, String> getMenuItems(Long hotelId) {
		// TODO Auto-generated method stub
		return null;
	}
}