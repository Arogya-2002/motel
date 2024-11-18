package com.kettle.serviceimpls;

import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kettle.entities.Booking;
import com.kettle.entities.Customer;
import com.kettle.entities.Hotel;
import com.kettle.entities.Room;
import com.kettle.repositories.BookingRepository;
import com.kettle.repositories.CustomerRepository;
import com.kettle.repositories.HotelRepository;
import com.kettle.repositories.RoomRepository;
import com.kettle.services.BookingService;

import dtos.BookingDto;
import jakarta.transaction.Transactional;

@Service
public class BookingServiceImpl implements BookingService{

	 @Autowired
	    private RoomRepository roomRepository;

	    @Autowired
	    private BookingRepository bookingRepository;

	    @Autowired
	    private CustomerRepository customerRepository;
	    
	    @Autowired
	    private HotelRepository hotelRepository;

	    @Transactional
	    public Booking createBooking(Long customerId, BookingDto bookingDto) {
	        // Fetch customer
	        Customer customer = customerRepository.findById(customerId)
	                .orElseThrow(() -> new RuntimeException("Customer not found"));

	        // Fetch hotel by ID
	        Hotel hotel = customer.getHotel(); // Assuming the customer is already associated with a hotel

	 List<Room> rooms = roomRepository.findByHotelAndRoomType(hotel, bookingDto.getRoomType());
	        
	        if (rooms.isEmpty()) {
	            throw new RuntimeException("Room of type " + bookingDto.getRoomType() + " not available in the hotel.");
	        }

	        // If rooms are found, pick the first room (or implement your own logic)
	        Room room = rooms.get(0); // Assuming you want to pick the first available room

	        // Calculate the total amount for the booking
	        long days = ChronoUnit.DAYS.between(bookingDto.getCheckInDate(), bookingDto.getCheckOutDate());
	        if (days <= 0) {
	            throw new RuntimeException("Check-out date must be after check-in date");
	        }

	        Double totalAmount = room.getPrice() * days;

	        // Create and save the booking
	        Booking booking = new Booking();
	        booking.setCustomer(customer);
	        booking.setRoom(room);
	        booking.setCheckInDate(bookingDto.getCheckInDate());
	        booking.setCheckOutDate(bookingDto.getCheckOutDate());
	        booking.setTotalAmount(totalAmount);

	        return bookingRepository.save(booking);
	    }

	    // Fetch available rooms based on hotel ID and room type
	    public List<Room> getAvailableRoomsForHotel(Long hotelId, String roomType) {
	        // Fetch the Hotel entity by its ID
	        Hotel hotel = hotelRepository.findById(hotelId)
	                .orElseThrow(() -> new RuntimeException("Hotel not found"));

	        // Now pass the Hotel entity to the repository method
	        return roomRepository.findByHotelAndRoomType(hotel, roomType);
	    }
}
