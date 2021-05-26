package com.mph.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mph.entity.Business;
import com.mph.entity.Customer;
import com.mph.entity.Employees;
import com.mph.entity.Student;
import com.mph.service.CustomerService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * The Class CustomerRestController.
 */
@CrossOrigin(origins = "*", allowCredentials = "false", methods = { RequestMethod.GET,
		RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT }, allowedHeaders = "*")
@RestController
@RequestMapping("/customer")



public class CustomerRestController {
	
	/** The customer service. */
	@Autowired
	CustomerService customerService;
	
	/** The Constant logger. */
	private static final Logger logger = Logger.getLogger("CustomerRestController.class");
	
	

	
	/**
	 * Creates the student.
	 *
	 * @param student the student
	 * @param sal the sal
	 * @return the student
	 */
	@PostMapping("/createStudent/{sal}")
	public Student createStudent(@RequestBody Student student, @PathVariable("sal") double sal) {
		logger.info("GETTING REQUEST FROM CLIENT TO CREATE ACCOUNT");
		System.out.println(student);

		student.setAccountbalance(500);
		student.setStipend(sal);
		customerService.createStudent(student);
		return student;

	}

	/**
	 * Creates the employee.
	 *  @author Mushahid
	 * @param employee the employee
	 * @param sal  This param  inclues 
	 *             salary of an employee
	 * @return the employees
	 */
	@PostMapping("/createEmployee/{sal}")
	public Employees createEmployee(@RequestBody Employees employee, @PathVariable("sal") double sal) {
		logger.info("GETTING REQUEST FROM CLIENT TO CREATE ACCOUNT");
		System.out.println(employee);

		employee.setSalary(sal);
		customerService.createEmployee(employee);
		return employee;
	}

	/**
	 * Creates the business.
	 * @author Mushahid
	 * @param business the business
	 * @param sal This param includes the 
	 *             turnoverperannum of business
	 * @return the business
	 */
	@PostMapping("/createBusiness/{sal}")
	public Business createBusiness(@RequestBody Business business, @PathVariable("sal") double sal) {
		logger.info("GETTING REQUEST FROM CLIENT TO CREATE ACCOUNT");
		System.out.println(business);

		business.setTurnOverPerAnnum(sal);
		customerService.createBusiness(business);
		return business;
	}

	/**
	 * Gets the customers.
	 *@author Swapna
	 * @return the customers
	 */
	@GetMapping(value = "/customerList", produces = "application/json")
	public ResponseEntity<List<Customer>> getCustomers() {
		logger.info("GETTING REQUEST FROM CLIENT TO GET THE LIST OF CUSTOMERS");
		List<Customer> customerList = customerService.getCustomerList();
		if (customerList.isEmpty()) {
			return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Customer>>(customerList, HttpStatus.OK);
	}

	/**
	 * Gets the customer.
	 * @author Neeha
	 * @param cid  This param includes 
	 *              the id of an customer
	 *                to retrive details
	 * @return the customer
	 */
	@GetMapping("/getCustomer/{cid}")
	public ResponseEntity<Customer> getCustomer(@PathVariable("cid") String cid) {
		Customer customer = new Customer();
		customer.setCustomerId(cid);
		Customer customerResult = customerService.getCustomer(customer);
		if (customerResult == null) {
			Customer customerEmpty = new Customer();
			customerEmpty.setCustomerId("notfound");
			return new ResponseEntity<Customer>(customerEmpty, HttpStatus.OK);
		}
		return new ResponseEntity<Customer>(customerResult, HttpStatus.OK);
	}

	/**
	 * Update customer.
	 *  @author Neeha
	 * @param customer This param includes
	 *               the details of customer
	 *               to be updated
	 * @return the response entity
	 */
	@PutMapping("/update")
	public ResponseEntity<List<Customer>> updateCustomer(@RequestBody Customer customer) {

		List<Customer> customerList = customerService.updateCustomer(customer);
		System.out.println(customerList);
		if (customerList.isEmpty()) {
			return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Customer>>(customerList, HttpStatus.OK);
	}

	/**
	 * Delete customer.
	 * @author Mohit
	 * @param id  This param includes which
	 *             customer should be deleted
	 * @return the response entity
	 */
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<List<Customer>> deleteCustomer(@PathVariable("id") String id) {
		List<Customer> customerList = customerService.deleteCustomer(id);
		System.out.println(customerList);
		if (customerList.isEmpty()) {
			return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Customer>>(customerList, HttpStatus.OK);
	}
	

}
