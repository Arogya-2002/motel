package com.kettle.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kettle.entities.Hotel;
import com.kettle.services.HotelService;

@RestController
@RequestMapping("/hotel-management")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping("/hotel/{hotelId}/addfoodinmenu")
    public ResponseEntity<Hotel> addFoodItem(@PathVariable Long hotelId, @RequestParam HashMap<String, Double> foodItem) {
        return ResponseEntity.ok(hotelService.addFoodItem(hotelId, foodItem));
    }

    @DeleteMapping("/hotel/{hotelId}/removefoodinmenu")
    public ResponseEntity<Hotel> removeFoodItem(@PathVariable Long hotelId, @RequestParam String foodItem) {
        return ResponseEntity.ok(hotelService.removeFoodItem(hotelId, foodItem));
    }

    @GetMapping("/hotel/{hotelId}/getmenuitems")
    public ResponseEntity<HashMap> getMenuItems(@PathVariable Long hotelId) {
        return ResponseEntity.ok(hotelService.getMenuItems(hotelId));
    }
}
