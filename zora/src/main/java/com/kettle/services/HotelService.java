package com.kettle.services;

import java.util.HashMap;
import java.util.List;

import com.kettle.entities.Hotel;

public interface HotelService {
	 public Hotel addFoodItem(Long hotelId, HashMap<String, Double> foodItem);
	 public Hotel removeFoodItem(Long hotelId, String foodItem);
	  public HashMap<Long,String > getMenuItems(Long hotelId);
}
