package com.kettle.services;

import java.util.List;

import com.kettle.entities.Customer;
import com.kettle.entities.Room;

import dtos.CustomerDto;

public interface CustomerService {
	public Customer registerCustomer(CustomerDto customerDto);
	 public Customer selectFoodItems(Long customerId, List<String> foodItems);
	 public List<Room> getAvailableRoomsForHotel(Long hotelId);

}
