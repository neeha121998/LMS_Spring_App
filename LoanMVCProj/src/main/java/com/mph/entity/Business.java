package com.mph.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

// TODO: Auto-generated Javadoc
/**
 * The Class Business.
 * @author Swapna
 */
@Entity
@DiscriminatorValue("Business")

public class Business extends Customer {

	/** The turn over per annum. */
	private double turnOverPerAnnum;

	/**
	 * Gets the turn over per annum.
	 *
	 * @return the turn over per annum
	 */
	public double getTurnOverPerAnnum() {
		return turnOverPerAnnum;
	}

	/**
	 * Sets the turn over per annum.
	 *
	 * @param turnOverPerAnnum the new turn over per annum
	 */
	public void setTurnOverPerAnnum(double turnOverPerAnnum) {
		this.turnOverPerAnnum = turnOverPerAnnum;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Business [turnOverPerAnnum=" + turnOverPerAnnum + "]";
	}

}
