package com.kettle.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kettle.enums.Gender;

import dtos.RoomDto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Hotel {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long HotelId;
	
	private String HotelOwnerFirstName;
	private String HotelOwnerLastName;
	
	private Gender gender;
	@Column(unique = true)
	private String HotelOwnerPhNo;
	@Column(unique = true)
	private String HotelOwnerMail;
	
	@Column(unique = true)
	private String HotelOwnerAadharNo;
	@Column(unique = true)
	private String HotelGstinNo;
	@Column(unique = true)
	private String RegistrationNo;
	
	@JsonIgnore
	@OneToMany(mappedBy = "hotel",cascade = CascadeType.ALL)
	private List<Room> room;
	
	@OneToMany(mappedBy = "hotel",cascade = CascadeType.ALL)
	private List<Food> food;
	
	@OneToMany(mappedBy = "hotel",cascade = CascadeType.ALL)
	private List<Customer> customers;
	
	

	public List<Food> getFood() {
		return food;
	}
	public void setFood(List<Food> food) {
		this.food = food;
	}
	public List<Room> getRoom() {
		return room;
	}
	public void setRoom(List<Room> room) {
		this.room = room;
	}
	public Long getHotelId() {
		return HotelId;
	}
	public void setHotelId(Long hotelId) {
		HotelId = hotelId;
	}
	public String getHotelOwnerFirstName() {
		return HotelOwnerFirstName;
	}
	public void setHotelOwnerFirstName(String hotelOwnerFirstName) {
		HotelOwnerFirstName = hotelOwnerFirstName;
	}
	public String getHotelOwnerLastName() {
		return HotelOwnerLastName;
	}
	public void setHotelOwnerLastName(String hotelOwnerLastName) {
		HotelOwnerLastName = hotelOwnerLastName;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public String getHotelOwnerPhNo() {
		return HotelOwnerPhNo;
	}
	public void setHotelOwnerPhNo(String hotelOwnerPhNo) {
		HotelOwnerPhNo = hotelOwnerPhNo;
	}
	public String getHotelOwnerMail() {
		return HotelOwnerMail;
	}
	public void setHotelOwnerMail(String hotelOwnerMail) {
		HotelOwnerMail = hotelOwnerMail;
	}
	public String getHotelOwnerAadharNo() {
		return HotelOwnerAadharNo;
	}
	public void setHotelOwnerAadharNo(String hotelOwnerAadharNo) {
		HotelOwnerAadharNo = hotelOwnerAadharNo;
	}
	public String getHotelGstinNo() {
		return HotelGstinNo;
	}
	public void setHotelGstinNo(String hotelGstinNo) {
		HotelGstinNo = hotelGstinNo;
	}
	public String getRegistrationNo() {
		return RegistrationNo;
	}
	public void setRegistrationNo(String registrationNo) {
		RegistrationNo = registrationNo;
	}
	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Hotel(Long hotelId, String hotelOwnerFirstName, String hotelOwnerLastName, Gender gender,
			String hotelOwnerPhNo, String hotelOwnerMail, String hotelOwnerAadharNo, String hotelGstinNo,
			String registrationNo) {
		super();
		HotelId = hotelId;
		HotelOwnerFirstName = hotelOwnerFirstName;
		HotelOwnerLastName = hotelOwnerLastName;
		this.gender = gender;
		HotelOwnerPhNo = hotelOwnerPhNo;
		HotelOwnerMail = hotelOwnerMail;
		HotelOwnerAadharNo = hotelOwnerAadharNo;
		HotelGstinNo = hotelGstinNo;
		RegistrationNo = registrationNo;
	}

	
	
}
