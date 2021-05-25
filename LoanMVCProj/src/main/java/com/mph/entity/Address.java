package com.mph.entity;

import javax.persistence.Embeddable;


/**
 * The Class Address.
 * @author Swapna
 */
@Embeddable

public class Address {
	
	/** The d no. */
	private String dNo;
	
	/** The street name. */
	private String streetName;
	
	/** The city. */
	private String city;
	
	/** The pincode. */
	private long pincode;

	/**
	 * Instantiates a new address.
	 */
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new address.
	 *
	 * @param dNo the d no
	 * @param streetName the street name
	 * @param city the city
	 * @param pincode the pincode
	 */
	public Address(String dNo, String streetName, String city, long pincode) {
		super();
		this.dNo = dNo;
		this.streetName = streetName;
		this.city = city;
		this.pincode = pincode;
	}

	/**
	 * Gets the d no.
	 *
	 * @return the d no
	 */
	public String getdNo() {
		return dNo;
	}

	/**
	 * Sets the d no.
	 *
	 * @param dNo the new d no
	 */
	public void setdNo(String dNo) {
		this.dNo = dNo;
	}

	/**
	 * Gets the street name.
	 *
	 * @return the street name
	 */
	public String getStreetName() {
		return streetName;
	}

	/**
	 * Sets the street name.
	 *
	 * @param streetName the new street name
	 */
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	/**
	 * Gets the city.
	 *
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Sets the city.
	 *
	 * @param city the new city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Gets the pincode.
	 *
	 * @return the pincode
	 */
	public long getPincode() {
		return pincode;
	}

	/**
	 * Sets the pincode.
	 *
	 * @param pincode the new pincode
	 */
	public void setPincode(long pincode) {
		this.pincode = pincode;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Address [dNo=" + dNo + ", streetName=" + streetName + ", city=" + city + ", pincode=" + pincode + "]";
	}

}
