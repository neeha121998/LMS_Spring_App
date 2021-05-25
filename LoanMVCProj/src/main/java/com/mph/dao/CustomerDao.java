package com.mph.dao;

import java.util.List;

import com.mph.entity.Business;
import com.mph.entity.Customer;
import com.mph.entity.Employees;
import com.mph.entity.Student;


/**
 * The Interface CustomerDao.
 */
public interface CustomerDao {
	
	/**
	 * Creates the customer.
	 *
	 * @param customer This Param includes 
	 *                  the customer object
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
	 * @param customer This Param includes 
	 *                  the customer object
	 * @return the customer
	 */
	public Customer getCustomer(Customer customer);
	
	/**
	 * Update customer.
	 *
	 * @param customer This Param includes 
	 *                  the customer object
	 * @return the list
	 */
	public List<Customer> updateCustomer(Customer customer);
	
	/**
	 * Delete customer.
	 *
	 * @param cid This Param includes the
	 *           id of the customer to be deleted
	 * @return the list
	 */
	public List<Customer> deleteCustomer(String customerid);
	
		
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
