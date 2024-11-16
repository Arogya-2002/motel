package com.kettle.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kettle.entities.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
List<Hotel> findByEnabled(boolean enabled);
	
	
}
