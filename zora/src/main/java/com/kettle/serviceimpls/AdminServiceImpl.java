package com.kettle.serviceimpls;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kettle.entities.Food;
import com.kettle.entities.Hotel;
import com.kettle.entities.Room;
import com.kettle.repositories.HotelRepository;
//import com.kettle.repositories.HotelRepository;
import com.kettle.services.AdminService;

import dtos.FoodDto;
import dtos.HotelDto;
import dtos.RoomDto;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private HotelRepository hotelRepository;

	@Override
	public Hotel addHotelWithRooms(HotelDto hotelDto) {
		Hotel hotel = new Hotel();
		hotel.setHotelOwnerFirstName(hotelDto.getHotelOwnerFirstName());
		hotel.setHotelOwnerLastName(hotelDto.getHotelOwnerLastName());
		hotel.setGender(hotelDto.getGender());
		hotel.setHotelOwnerPhNo(hotelDto.getHotelOwnerPhNo());
		hotel.setHotelOwnerAadharNo(hotelDto.getHotelOwnerAadharNo());
		hotel.setHotelOwnerMail(hotelDto.getHotelOwnerMail());
		hotel.setHotelGstinNo(hotelDto.getHotelGstinNo());
		hotel.setRegistrationNo(hotelDto.getRegistrationNo());
		
		
		List<Room> rooms = new ArrayList<>();
		for (RoomDto roomDTO : hotelDto.getRooms()) {
            Room room = new Room();
            room.setRoomType(roomDTO.getRoomType());
            room.setPrice(roomDTO.getPrice());
            room.setAvailability(roomDTO.isAvailability());
            room.setHotel(hotel);  // Set the hotel reference

            rooms.add(room);
        }

        hotel.setRoom(rooms);
        
        
        List<Food> foods =new ArrayList<>();
        for (FoodDto foodDto: hotelDto.getFoods()) {
        	Food food = new Food();
        	food.setFoodId(foodDto.getFoodId());
        	food.setFoodName(foodDto.getFoodName());
        	food.setPrice(foodDto.getPrice());
        	food.setHotel(hotel);
        	foods.add(food);
        }
        hotel.setFood(foods);
        
        
        return hotelRepository.save(hotel);
	}

	@Override
	public Hotel enableHotel(Long hotelId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hotel disableHotel(Long hotelId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Hotel> getAllEnabledHotels() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
//	public Hotel addHotel(Hotel hotel) {
//		
//		return hotelRepository.save(hotel);
//	}
//
//	@Override
//	public Hotel enableHotel(Long hotelId) {
//		Hotel hotel = hotelRepository.findById(hotelId)
//                .orElseThrow(() -> new RuntimeException("Hotel not found"));    
//        return hotelRepository.save(hotel);
//	}
//
//	@Override
//	public Hotel disableHotel(Long hotelId) {
//		Hotel hotel = hotelRepository.findById(hotelId)
//                .orElseThrow(() -> new RuntimeException("Hotel not found"));
//        return hotelRepository.save(hotel);
//	}
//
//	@Override
//	public List<Hotel> getAllEnabledHotels() {
//		  return hotelRepository.findByEnabled(true);
//	}

}
