package com.kettle.serviceimpls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kettle.entities.Room;
import com.kettle.repositories.RoomRepository;
import com.kettle.services.RoomService;


@Service
public class RoomServiceImpl implements RoomService{

	@Autowired
	private RoomRepository roomRepository;
	
	@Override
	public Room addRoom(Room room) {
		// TODO Auto-generated method stub
		return roomRepository.save(room);
	}

}
