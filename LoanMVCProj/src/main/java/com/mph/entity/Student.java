package com.mph.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

// TODO: Auto-generated Javadoc
/**
 * The Class Student.
 * @author Mushahid
 */
@Entity
@DiscriminatorValue("STUDENT")
public class Student extends Customer {

	/** The stipend. */
	private double stipend;

	/**
	 * Gets the stipend.
	 *
	 * @return the stipend
	 */
	public double getStipend() {
		return stipend;
	}

	/**
	 * Sets the stipend.
	 *
	 * @param stipend the new stipend
	 */
	public void setStipend(double stipend) {
		this.stipend = stipend;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Student [stipend=" + stipend + "]";
	}
}
