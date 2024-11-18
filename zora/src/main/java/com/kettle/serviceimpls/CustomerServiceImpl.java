package com.kettle.serviceimpls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kettle.entities.Customer;
import com.kettle.entities.Hotel;
import com.kettle.entities.Room;
import com.kettle.repositories.CustomerRepository;
import com.kettle.repositories.HotelRepository;
import com.kettle.repositories.RoomRepository;
import com.kettle.services.CustomerService;

import dtos.CustomerDto;
@Service
public class CustomerServiceImpl implements CustomerService{

	 @Autowired
	    private RoomRepository roomRepository;
	    @Autowired
	    private CustomerRepository customerRepository;
	    
	    @Autowired
	    private HotelRepository hotelRepository;
	@Override
	public Customer registerCustomer(CustomerDto customerDto) {
		Customer customer = new Customer();
		customer.setFirstName(customerDto.getFirstName());
		customer.setLastName(customerDto.getLastName());
		customer.setCustomerPhNo(customerDto.getCustomerPhNo());
		customer.setCustomerAadharNo(customerDto.getCustomerAadharNo());
		customer.setEmail(customerDto.getEmail());
		customer.setCustomerImage(customerDto.getCustomerImage());
		customer.setGender(customerDto.getGender());
		
		if (customerDto.getHotelId() != null) {
            Hotel hotel = hotelRepository.findById(customerDto.getHotelId())
                    .orElseThrow(() -> new RuntimeException("Hotel not found"));
            customer.setHotel(hotel);
        }

        return customerRepository.save(customer);
	}
	

	@Override
	public Customer selectFoodItems(Long customerId, List<String> foodItems) {
		Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

//        customer.getOrderedFood().addAll(foodItems);
        return customerRepository.save(customer);
	}

	@Override
	public List<Room> getAvailableRoomsForHotel(Long hotelId) {
	    // Fetch the Hotel entity using the hotel ID
	    Hotel hotel = hotelRepository.findById(hotelId)
	            .orElseThrow(() -> new RuntimeException("Hotel not found"));

	    // Now pass the Hotel entity to the repository method
	    return null;


}
}


