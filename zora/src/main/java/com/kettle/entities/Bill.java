package com.kettle.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Bill {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long billId;

	    @ManyToOne
	    @JoinColumn(name = "customer_id")
	    private Customer customer;

	    public Customer getCustomer() {
			return customer;
		}
		public void setCustomer(Customer customer) {
			this.customer = customer;
		}
		@ManyToOne
	    @JoinColumn(name = "hotel_id")
	    private Hotel hotel;

	    private Double roomCharges;
	    private Double foodCharges;
	    private Double totalAmount;
	    private LocalDate billDate;
		public Long getBillId() {
			return billId;
		}
		public void setBillId(Long billId) {
			this.billId = billId;
		}
		public Hotel getHotel() {
			return hotel;
		}
		public void setHotel(Hotel hotel) {
			this.hotel = hotel;
		}
		public Double getRoomCharges() {
			return roomCharges;
		}
		public void setRoomCharges(Double roomCharges) {
			this.roomCharges = roomCharges;
		}
		public Double getFoodCharges() {
			return foodCharges;
		}
		public void setFoodCharges(Double foodCharges) {
			this.foodCharges = foodCharges;
		}
		public Double getTotalAmount() {
			return totalAmount;
		}
		public void setTotalAmount(Double totalAmount) {
			this.totalAmount = totalAmount;
		}
		public LocalDate getBillDate() {
			return billDate;
		}
		public void setBillDate(LocalDate billDate) {
			this.billDate = billDate;
		}

}
