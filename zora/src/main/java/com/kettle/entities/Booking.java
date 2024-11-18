package com.kettle.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Booking {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long bookingId;

	    @ManyToOne
	    @JoinColumn(name = "customer_id")
	    private Customer customer;

	    @ManyToOne
	    @JoinColumn(name = "room_id")
	    private Room room;
	    
	    private LocalDate checkInDate;
	    private LocalDate checkOutDate;

	    private Double totalAmount;

		public Booking() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Booking(Long bookingId, Customer customer, Room room, LocalDate checkInDate, LocalDate checkOutDate,
				Double totalAmount) {
			super();
			this.bookingId = bookingId;
			this.customer = customer;
			this.room = room;
			this.checkInDate = checkInDate;
			this.checkOutDate = checkOutDate;
			this.totalAmount = totalAmount;
		}

		public Long getBookingId() {
			return bookingId;
		}

		public void setBookingId(Long bookingId) {
			this.bookingId = bookingId;
		}

		public Customer getCustomer() {
			return customer;
		}

		public void setCustomer(Customer customer) {
			this.customer = customer;
		}

		public Room getRoom() {
			return room;
		}

		public void setRoom(Room room) {
			this.room = room;
		}

		public LocalDate getCheckInDate() {
			return checkInDate;
		}

		public void setCheckInDate(LocalDate checkInDate) {
			this.checkInDate = checkInDate;
		}

		public LocalDate getCheckOutDate() {
			return checkOutDate;
		}

		public void setCheckOutDate(LocalDate checkOutDate) {
			this.checkOutDate = checkOutDate;
		}

		public Double getTotalAmount() {
			return totalAmount;
		}

		public void setTotalAmount(Double totalAmount) {
			this.totalAmount = totalAmount;
		}
	    
	    
}
