package com.kettle.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kettle.entities.Customer;
import com.kettle.entities.FoodOrder;

public interface FoodOrderRepository extends JpaRepository<FoodOrder, Long>{
	 List<FoodOrder> findByCustomer(Customer customer);
}
