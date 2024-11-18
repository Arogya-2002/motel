package dtos;

import java.util.List;

import com.kettle.enums.Gender;

public class HotelDto {
	private String name;      // Hotel details
    private String address;
    
    private String HotelOwnerFirstName;
	private String HotelOwnerLastName;
	private Gender gender;
	private String HotelOwnerPhNo;
	private String HotelOwnerMail;	
	private String HotelOwnerAadharNo;
	private String HotelGstinNo;
	private String RegistrationNo;
    private List<RoomDto> rooms;
    private List<FoodDto> foods;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public List<RoomDto> getRooms() {
		return rooms;
	}
	public void setRooms(List<RoomDto> rooms) {
		this.rooms = rooms;
	}
	public List<FoodDto> getFoods() {
		return foods;
	}
	public void setFoods(List<FoodDto> foods) {
		this.foods = foods;
	}

}
