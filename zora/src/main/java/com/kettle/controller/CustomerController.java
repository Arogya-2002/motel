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

import com.kettle.entities.Bill;
import com.kettle.entities.Customer;
import com.kettle.entities.Room;
import com.kettle.enums.Gender;
import com.kettle.services.CustomerService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    // Endpoint to register for a room and order food items
    @PostMapping(value="/{customerId}/register",consumes = {"multipart/form-data"})
    public ResponseEntity<Customer> registerForRoomAndFood(
    		@RequestParam Long customerId,
    		@RequestParam String firstName,
    		@RequestParam String lastName,
    		@RequestParam Gender gender,
    		@RequestParam String customerPhNo,
    		@RequestParam String email,
    		@RequestParam String customerAadharNo,
    		@RequestParam("customerImage") MultipartFile customerImage) throws IOException {
    	
    	 byte[] imageBytes = customerImage.getBytes();
    	
    Customer customer = new Customer(customerId,firstName,lastName,gender,customerPhNo,email,customerAadharNo,imageBytes,null,null);
   Customer  registeredCustomer=customerService.registerCustomer(customer);
    		 return ResponseEntity.ok(registeredCustomer);
    }
    
    

    // Endpoint to generate a bill for the customer
    @GetMapping("/{customerId}/bill")
    public ResponseEntity<Bill> generateBill(@PathVariable Long customerId) {
        Bill bill = customerService.generateBill(customerId);
        return ResponseEntity.ok(bill);
    }
}
