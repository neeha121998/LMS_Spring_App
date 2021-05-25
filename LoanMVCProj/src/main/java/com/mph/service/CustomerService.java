package com.mph.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mph.entity.Business;
import com.mph.entity.Customer;
import com.mph.entity.Employees;
import com.mph.entity.Student;


/**
 * The Interface CustomerService.
 */

public interface CustomerService {
	
	/**
	 * Creates the customer.
	 *
	 * @param customer the customer
	 */
	public void createCustomer(Customer customer);

	/**
	 * Gets the customer list.
	 *
	 * @return the customer list
	 */
	public List<Customer> getCustomerList();

	/**
	 * Gets the customer.
	 *
	 * @param customer the customer
	 * @return the customer
	 */
	public Customer getCustomer(Customer customer);

	/**
	 * Update customer.
	 *
	 * @param customer the customer
	 * @return the list
	 */
	public List<Customer> updateCustomer(Customer customer);

	/**
	 * Delete customer.
	 *
	 * @param cid the cid
	 * @return the list
	 */
	public List<Customer> deleteCustomer(String customerid);

	/**
	 * Validation.
	 *
	 * @param customer the customer
	 * @return the string
	 */
	public String validation(Customer customer);

	/**
	 * Creates the student.
	 *
	 * @param student the student
	 */
	public void createStudent(Student student);

	/**
	 * Creates the employee.
	 *
	 * @param employees the employees
	 */
	public void createEmployee(Employees employees);

	/**
	 * Creates the business.
	 *
	 * @param business the business
	 */
	public void createBusiness(Business business);
}
