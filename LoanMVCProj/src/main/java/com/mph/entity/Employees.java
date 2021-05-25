package com.mph.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

// TODO: Auto-generated Javadoc
/**
 * The Class Employees.
 * @author Mohit
 */
@Entity
@DiscriminatorValue("Employee")
public class Employees extends Customer {
	
	/** The salary. */
	private double salary;

	/**
	 * Gets the salary.
	 *
	 * @return the salary
	 */
	public double getSalary() {
		return salary;
	}

	/**
	 * Sets the salary.
	 *
	 * @param salary the new salary
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Employee [salary=" + salary + "]";
	}

}
