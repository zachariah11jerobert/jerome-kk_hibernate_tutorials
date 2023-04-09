package com.infotech.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "address_table")
public class Address {

	@Id
	@Column(name = "street_name", length = 50)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String street;
	@Column(name = "city_name", length = 50)
	private String city;
	@Column(name = "state_name")
	private String state;
	@Column(name = "pin_code")
	private Long pincode;
	
	@OneToOne(mappedBy="address")
	private Employee employee;

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Long getPincode() {
		return pincode;
	}

	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}

}
