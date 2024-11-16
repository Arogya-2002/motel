package com.kettle.serviceimpls;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kettle.entities.Bill;
import com.kettle.entities.Customer;
import com.kettle.entities.Hotel;
import com.kettle.entities.Room;
import com.kettle.repositories.BillRepository;
import com.kettle.repositories.CustomerRepository;
import com.kettle.repositories.HotelRepository;
import com.kettle.repositories.RoomRepository;
import com.kettle.services.CustomerService;
@Service
public class CustomerServiceImpl implements CustomerService{

	 @Autowired
	    private RoomRepository roomRepository;
	    @Autowired
	    private CustomerRepository customerRepository;
	    @Autowired
	    private BillRepository billRepository;
	    
	    @Autowired
	    private HotelRepository hotelRepository;
	@Override
	public Customer registerCustomer(Customer customer) {
		
        return customerRepository.save(customer);
	}
	

	@Override
	public Bill generateBill(Long customerId) {
		Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        List<Long> roomCharges = customer.getRoomList();
        List<String> foodCharges = customer.getFoodList();

//        Double totalAmount = roomCharges + foodCharges;
//        
        Bill bill = new Bill();
//        bill.setCustomer(customer);
//        bill.setRoomCharges(roomCharges);
//        bill.setFoodCharges(foodCharges);
//        bill.setTotalAmount(totalAmount);
//        bill.setBillDate(LocalDate.now());
        
        return billRepository.save(bill);
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
	    return roomRepository.findByHotelAndAvailability(hotel, true);


}
}


