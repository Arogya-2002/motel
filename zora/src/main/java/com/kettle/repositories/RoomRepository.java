package com.kettle.repositories;

import java.util.List;

//import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.kettle.entities.Hotel;
//import com.kettle.entities.Hotel;
import com.kettle.entities.Room;

public interface RoomRepository extends JpaRepository<Room, Long>{

	List<Room> findByHotelAndRoomType(Hotel hotel, String roomType);}
