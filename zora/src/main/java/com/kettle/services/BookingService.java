package com.kettle.services;

import java.util.List;

import com.kettle.entities.Booking;
import com.kettle.entities.Room;

import dtos.BookingDto;

public interface BookingService {

    public Booking createBooking(Long customerId, BookingDto bookingDto);
    public List<Room> getAvailableRoomsForHotel(Long hotelId, String roomType);
 
}
