package com.kettle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kettle.entities.Food;

public interface FoodRepository extends JpaRepository<Food, Long> {

}
