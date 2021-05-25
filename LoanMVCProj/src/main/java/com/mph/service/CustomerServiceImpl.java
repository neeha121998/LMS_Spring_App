package com.mph.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mph.dao.CustomerDao;
import com.mph.entity.Business;
import com.mph.entity.Customer;
import com.mph.entity.Employees;
import com.mph.entity.Student;

// TODO: Auto-generated Javadoc
/**
 * The Class CustomerServiceImpl.
 * @author Neeha
 */
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
	
	/** The customer dao. */
	@Autowired
	CustomerDao customerDao;

	/**
	 * Creates the customer.
	 *
	 * @param customer the customer
	 */
	@Override
	public void createCustomer(Customer customer) {
		customerDao.createCustomer(customer);
	}

	/**
	 * Gets the customer list.
	 *
	 * @return the customer list
	 */
	@Override
	public List<Customer> getCustomerList() {

		return customerDao.getCustomerList();
	}

	/**
	 * Gets the customer.
	 *
	 * @param customer the customer
	 * @return the customer
	 */
	@Override
	public Customer getCustomer(Customer customer) {

		return customerDao.getCustomer(customer);
	}

	/**
	 * Update customer.
	 *
	 * @param customer the customer
	 * @return the list
	 */
	@Override
	public List<Customer> updateCustomer(Customer customer) {

		return customerDao.updateCustomer(customer);
	}

	/**
	 * Delete customer.
	 *
	 * @param cid the cid
	 * @return the list
	 */
	@Override
	public List<Customer> deleteCustomer(String customerid) {

		return customerDao.deleteCustomer(customerid);
	}

	/**
	 * Validation.
	 *
	 * @param customer the customer
	 * @return the string
	 */
	

	/**
	 * Creates the student.
	 *
	 * @param student the student
	 */
	@Override
	public void createStudent(Student student) {
		customerDao.createStudent(student);

	}

	/**
	 * Creates the employee.
	 *
	 * @param employees the employees
	 */
	@Override
	public void createEmployee(Employees employees) {
		customerDao.createEmployee(employees);

	}

	/**
	 * Creates the business.
	 *
	 * @param business the business
	 */
	@Override
	public void createBusiness(Business business) {
		customerDao.createBusiness(business);

	}

	@Override
	public String validation(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}
}
