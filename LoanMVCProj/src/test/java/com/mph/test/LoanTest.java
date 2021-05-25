package com.mph.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mph.dao.CustomerDao;
import com.mph.dao.LoanDao;


/**
 * The Class LoanTest.
 * @author Swapna
 */
public class LoanTest {

	/** The loan dao. */
	static LoanDao loanDao;

	/**
	 * Setup.
	 */
	@BeforeClass
	public static void setup() {
		System.out.println("Before class");
		ApplicationContext context = new ClassPathXmlApplicationContext("dispserv-servlet.xml");
		loanDao = (LoanDao) context.getBean("loanDao");
	}

	/**
	 * Gets the loan list.
	 *
	 * @return the loan list
	 */
	@Test
	public void testgetLoanList() {

		assertTrue((loanDao.getPendingLoans()).size() >= 1);
	}
	
	/**
	 * Testget loan by id.
	 */
	@Test
	public void testgetLoanById() {

		assertEquals((loanDao.getLoan(1).getLoantype()),"Home");
	}
	
	

}
