package com.demo.hibernate;

import javax.persistence.*;

@Embeddable
public class Address {
	
	@Column(name="DOOR_NO")
	private String doorNo;
	
	@Column(name="STREET")
	private String street;
	
	@Column(name="PIN")
	private String pinCode;
	public Address() {
		
	}
	public Address(String doorNo, String street, String pinCode) {
		super();
		this.doorNo = doorNo;
		this.street = street;
		this.pinCode = pinCode;
	}
	public String getDoorNo() {
		return doorNo;
	}
	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	
}
