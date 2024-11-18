package dtos;

import com.kettle.enums.Gender;

import jakarta.persistence.Lob;

public class CustomerDto {
	private String firstName;
	private String lastName;
	
	private Gender gender;
	private String customerPhNo;
	private String email;
	private String customerAadharNo;
	@Lob
	private byte[] customerImage;
	 private Long hotelId;
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
	public Long getHotelId() {
		return hotelId;
	}
	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}
	public CustomerDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomerDto(String firstName, String lastName, Gender gender, String customerPhNo, String email,
			String customerAadharNo, byte[] customerImage, Long hotelId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.customerPhNo = customerPhNo;
		this.email = email;
		this.customerAadharNo = customerAadharNo;
		this.customerImage = customerImage;
		this.hotelId = hotelId;
	}
	
}
