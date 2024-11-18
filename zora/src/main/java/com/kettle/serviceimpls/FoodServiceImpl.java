package com.kettle.serviceimpls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kettle.entities.Customer;
import com.kettle.entities.Food;
import com.kettle.entities.FoodOrder;
import com.kettle.entities.Room;
import com.kettle.repositories.CustomerRepository;
import com.kettle.repositories.FoodOrderRepository;
import com.kettle.repositories.FoodRepository;
import com.kettle.repositories.RoomRepository;

@Service
public class FoodServiceImpl {

	@Autowired
    private FoodOrderRepository foodOrderRepository;

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private CustomerRepository customerRepository;
    
    @Autowired
    private RoomRepository roomRepository;

    public FoodOrder createFoodOrder(Long roomId, List<Long> foodIds, Integer quantity) {
        // Fetch the room by ID
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new RuntimeException("Room not found"));
        
        // Fetch the food items by IDs
        List<Food> foods = foodRepository.findAllById(foodIds);
        
        if (foods.isEmpty()) {
            throw new RuntimeException("Food items not found");
        }

        // Create and set up the food order
        FoodOrder foodOrder = new FoodOrder();
        foodOrder.setRoom(room);
        foodOrder.setOrderedFoods(foods);
        foodOrder.setQuantity(quantity);  // Assuming quantity applies to each food item
        foodOrder.setCustomer(room.getCustomer());  // Assuming the room is already associated with the customer
        
        // Calculate total amount
        foodOrder.calculateTotalAmount();
        
        // Save the food order
        return foodOrderRepository.save(foodOrder);
    }

}
