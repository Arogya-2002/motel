package com.kettle.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kettle.entities.Booking;
import com.kettle.entities.Customer;
import com.kettle.entities.Room;
import com.kettle.enums.Gender;
import com.kettle.services.BookingService;
import com.kettle.services.CustomerService;

import dtos.BookingDto;
import dtos.CustomerDto;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    
    @Autowired
    private BookingService bookingService;

    // Endpoint to register for a room and order food items
    @PostMapping(value="/register",consumes = {"multipart/form-data"})
    public ResponseEntity<Customer> registerandChooseHotel(
    		@RequestParam String firstName,
    		@RequestParam String lastName,
    		@RequestParam Gender gender,
    		@RequestParam String customerPhNo,
    		@RequestParam String email,
    		@RequestParam String customerAadharNo,
    		@RequestParam("customerImage") MultipartFile customerImage,
    		@RequestParam Long hotelId
    		) throws IOException {
    	
    	 byte[] imageBytes = customerImage.getBytes();
    	
    CustomerDto customerDto = new CustomerDto(firstName,lastName,gender,customerPhNo,email,customerAadharNo,imageBytes,hotelId);
   Customer  registeredCustomer=customerService.registerCustomer(customerDto);
    		 return ResponseEntity.ok(registeredCustomer);
    }
    
    @PostMapping("/create/{customerId}")
    public ResponseEntity<Booking> createBooking(@PathVariable Long customerId, @RequestBody BookingDto bookingDto) {
        Booking booking = bookingService.createBooking(customerId, bookingDto);
        return ResponseEntity.ok(booking);
    }
    
    @GetMapping("/available-rooms/{hotelId}")
    public ResponseEntity<List<Room>> getAvailableRooms(@PathVariable Long hotelId, @RequestParam String roomType) {
        List<Room> availableRooms = bookingService.getAvailableRoomsForHotel(hotelId, roomType);
        return ResponseEntity.ok(availableRooms);
    }
    
    }
