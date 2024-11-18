package com.kettle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.kettle.entities.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {

}
