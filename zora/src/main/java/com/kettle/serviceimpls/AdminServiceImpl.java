package com.kettle.serviceimpls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kettle.entities.Hotel;
import com.kettle.entities.Room;
import com.kettle.repositories.HotelRepository;
import com.kettle.repositories.RoomRepository;
import com.kettle.services.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private HotelRepository hotelRepository;
	
	@Autowired
	private RoomRepository roomRepository;
	public Hotel addHotel(Hotel hotel,Room room) {
		hotel.setEnabled(false);
		roomRepository.save(room);
		return hotelRepository.save(hotel);
	}

	@Override
	public Hotel enableHotel(Long hotelId) {
		Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new RuntimeException("Hotel not found"));
        hotel.setEnabled(true);
        return hotelRepository.save(hotel);
	}

	@Override
	public Hotel disableHotel(Long hotelId) {
		Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new RuntimeException("Hotel not found"));
        hotel.setEnabled(false);
        return hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAllEnabledHotels() {
		  return hotelRepository.findByEnabled(true);
	}

}
