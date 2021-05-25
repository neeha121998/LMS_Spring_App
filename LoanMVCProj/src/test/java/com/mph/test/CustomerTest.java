package com.mph.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mph.dao.CustomerDao;

import com.mph.entity.Customer;


/**
 * The Class CustomerTest.
 * @author Mohit
 */
public class CustomerTest {
	
	/** The customer dao. */
	static CustomerDao customerDao;

	/**
	 * Setup.
	 */
	@BeforeClass
	public static void setup() {
		System.out.println("Before class");
		ApplicationContext context = new ClassPathXmlApplicationContext("dispserv-servlet.xml");
		customerDao = (CustomerDao) context.getBean("customerDao");
	}

	/**
	 * Gets the customer list.
	 *
	 * @return the customer list
	 */
	@Test
	public void getCustomerList() {

		assertTrue((customerDao.getCustomerList()).size() >= 1);
	}

	/**
	 * Test get customer.
	 */
	@Test
	public void testGetCustomer() {
		Customer customer = new Customer();
		customer.setCustomerId("L123456789123");
		// customerDao.deleteCustomer("L1111111111111111");
		assertEquals(customerDao.getCustomer(customer).getFirstName(), "Navya sree");
	}

}
