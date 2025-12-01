package com.demo.beans;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	private int aid;
	private String Street;
	private String city;
	private String pincode;
	public Address() {
		super();
	}
	public Address(int aid, String street, String city, String pincode) {
		super();
		this.aid = aid;
		Street = street;
		this.city = city;
		this.pincode = pincode;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getStreet() {
		return Street;
	}
	public void setStreet(String street) {
		Street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "Address [aid=" + aid + ", Street=" + Street + ", city=" + city + ", pincode=" + pincode + "]";
	}
	
	
}
