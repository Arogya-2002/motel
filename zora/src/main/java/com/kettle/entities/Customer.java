package com.kettle.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kettle.enums.Gender;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerId;
	
	private String firstName;
	private String lastName;
	
	private Gender gender;
	
	@Column(unique = true)
	private String customerPhNo;
	
	@Column(unique = true)
	private String email;
	
	@Column(unique = true)
	private String customerAadharNo;
	
	@Lob
	private byte[] customerImage;
	
	@ManyToOne
	@JoinColumn(name ="hotel_id")
	private Hotel hotel;
	
		public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

		public Long getCustomerId() {
			return customerId;
		}

		public void setCustomerId(Long customerId) {
			this.customerId = customerId;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public Gender getGender() {
			return gender;
		}

		public void setGender(Gender gender) {
			this.gender = gender;
		}

		public String getCustomerPhNo() {
			return customerPhNo;
		}

		public void setCustomerPhNo(String customerPhNo) {
			this.customerPhNo = customerPhNo;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getCustomerAadharNo() {
			return customerAadharNo;
		}

		public void setCustomerAadharNo(String customerAadharNo) {
			this.customerAadharNo = customerAadharNo;
		}

		public byte[] getCustomerImage() {
			return customerImage;
		}

		public void setCustomerImage(byte[] customerImage) {
			this.customerImage = customerImage;
		}
		public Customer() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Customer(Long customerId, String firstName, String lastName, Gender gender, String customerPhNo,
				String email, String customerAadharNo, byte[] customerImage, Hotel hotel) {
			super();
			this.customerId = customerId;
			this.firstName = firstName;
			this.lastName = lastName;
			this.gender = gender;
			this.customerPhNo = customerPhNo;
			this.email = email;
			this.customerAadharNo = customerAadharNo;
			this.customerImage = customerImage;
			this.hotel = hotel;
		}
	
}
