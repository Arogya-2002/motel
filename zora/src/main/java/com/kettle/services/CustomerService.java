package com.kettle.services;

import java.util.List;

import com.kettle.entities.Bill;
import com.kettle.entities.Customer;
import com.kettle.entities.Room;

public interface CustomerService {
	public Customer registerCustomer(Customer customer);
	 public Bill generateBill(Long customerId);
	 public Customer selectFoodItems(Long customerId, List<String> foodItems);
	 public List<Room> getAvailableRoomsForHotel(Long hotelId);

}
