package com.kettle.services;

import java.util.List;

import com.kettle.entities.FoodOrder;

public interface FoodOrderService {
	public FoodOrder createFoodOrder(Long roomId, List<Long> foodIds, Integer quantity);
	 
}
