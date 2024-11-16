package com.kettle.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kettle.entities.Hotel;
import com.kettle.entities.Room;
import com.kettle.enums.Gender;
import com.kettle.services.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/addhotel")
    public ResponseEntity<Hotel> addHotel(@RequestParam  Long hotelId,
    		@RequestParam String hotelOwnerFirstName,
    		@RequestParam String hotelOwnerLastName,
    		@RequestParam Gender gender,
    		@RequestParam String hotelOwnerPhNo,
    		@RequestParam String hotelOwnerMail,
    		@RequestParam String hotelOwnerAadharNo,
    		@RequestParam String hotelGstinNo,
    		@RequestParam String registrationNo,
    		@RequestParam Long roomId,
    		@RequestParam HashMap<Long, String> roomType,
    		@RequestParam HashMap<String, Double> price) {
    	
    	Hotel hotel = new Hotel(hotelId,hotelOwnerFirstName,hotelOwnerLastName,gender,hotelOwnerPhNo,hotelOwnerMail,hotelOwnerAadharNo,hotelGstinNo,registrationNo,false);
    	Room room = new Room(roomId,roomType,price,true,null);
    	adminService.addHotel(hotel,room);
        return ResponseEntity.ok(hotel);
    }

    @PutMapping("/hotel/enable/{id}")
    public ResponseEntity<Hotel> enableHotel(@PathVariable Long id) {
        return ResponseEntity.ok(adminService.enableHotel(id));
    }

    @PutMapping("/hotel/disable/{id}")
    public ResponseEntity<Hotel> disableHotel(@PathVariable Long id) {
        return ResponseEntity.ok(adminService.disableHotel(id));
    }

    @GetMapping("/getallhotels")
    public ResponseEntity<List<Hotel>> getEnabledHotels() {
        return ResponseEntity.ok(adminService.getAllEnabledHotels());
    }
}