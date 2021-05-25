package com.mph.controller;

import java.util.Collections;
import java.util.Comparator;
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

import com.mph.entity.Customer;
import com.mph.entity.Loan;
import com.mph.service.CustomerService;
import com.mph.service.LoanService;

/**
 * The Class LoanRestController.
 */
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", methods = { RequestMethod.GET,
		RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT }, allowedHeaders = "*")
@RestController
@RequestMapping("/loan")
public class LoanRestController {

	/** The customer service. */
	@Autowired
	CustomerService customerService;
	
	/** The Constant logger. */
	private static final Logger logger = Logger.getLogger("LoanRestController.class");
	
	/** The loan service. */
	@Autowired
	LoanService loanService;

	/**
	 * Creates the loan.
	 * 
	 * @author Mohit
	 * @param loan       This param includes all the loan details
	 * @param customerId This param includes the Id of the customer
	 */
	@PostMapping("/create/{id}")
	public void createLoan(@RequestBody Loan loan, @PathVariable("id") String customerId) {
		logger.info("GETTING REQUEST FROM CLIENT TO CREATE LOAN");
		Customer customer = new Customer();
		customer.setCustomerId(customerId);
		loan.setCustomer(customerService.getCustomer(customer));
		loan.setStatus("pending");
		loanService.createLoan(loan);

	}

	/**
	 * Gets the loan list.
	 * 
	 * @author NavyaSree
	 * @param customerId This param includes Id of the Customer
	 * @return the loan list
	 */
	@GetMapping("/getList/{id}")
	public ResponseEntity<List<Loan>> getLoanList(@PathVariable("id") String customerId) {
		List<Loan> loanList = loanService.getLoanList(customerId);
		System.out.println(loanList);
		return new ResponseEntity<List<Loan>>(loanList, HttpStatus.OK);
	}

	/**
	 * Gets the loan.
	 * 
	 * @author NavyaSree
	 * @param loanId This param includes the Id of loan
	 * @return the loan object
	 */
	@GetMapping("/getLoan/{id}")
	public ResponseEntity<Loan> getLoan(@PathVariable("id") int loanId) {
		logger.info("GETTING REQUEST FROM CLIENT TO GET LOAN");
		Loan loan = loanService.getLoan(loanId);

		return new ResponseEntity<Loan>(loan, HttpStatus.OK);
	}

	/**
	 * Update loan.
	 * 
	 * @author Neeha
	 * @param loan This param includes the loan details that to be updated
	 */
	@PutMapping("/update")
	public void updateLoan(@RequestBody Loan loan) {
		MailHelper mail = new MailHelper();
		if (loan.getStatus() != "pending") {
			mail.sendMail(loan.getCustomer().getEmailId(), loan.getStatus());
		}
		loanService.updateLoan(loan);
	}

	/**
	 * Delete loan.
	 * 
	 * @author Neeha
	 * @param loanId This param includes the Id of the loan to be deleted
	 */
	@DeleteMapping("/delete/{id}")
	public void deleteLoan(@PathVariable("id") int loanId) {
		loanService.deleteLoan(loanId);

	}

	/**
	 * Gets the pending loans.
	 * 
	 * @author Swapna
	 * @return the pending loans
	 */
	@GetMapping("/getPendingLoans")
	public ResponseEntity<List<Loan>> getPendingLoans() {
		List<Loan> loanList = loanService.getPendingLoans();
		Collections.sort(loanList, listComparator);

		return new ResponseEntity<List<Loan>>(loanList, HttpStatus.OK);
	}

	/**
	 * Gets the non pending loans.
	 * 
	 * @author Navyasree
	 * @return the non pending loans
	 */
	@GetMapping("/getNonPendingLoans")
	public ResponseEntity<List<Loan>> getNonPendingLoans() {
		List<Loan> loanList = loanService.getNonPendingLoans();

		return new ResponseEntity<List<Loan>>(loanList, HttpStatus.OK);
	}

	/**
	 * Approve loan.
	 * 
	 * @author Neeha
	 * @param loan This param includes the loan details that are approved
	 */
	@PutMapping("/approve")
	public void approveLoan(@RequestBody Loan loan) {
		MailHelper mail = new MailHelper();
		System.out.println(loan);
		loan.setStatus("Approved");
		Customer c = loan.getCustomer();
		mail.sendMail(c.getEmailId(), "Approved");
		double balance = loan.getCustomer().getAccountbalance();
		System.out.println("balance" + balance);
		double loanAmount = loan.getLoanAmount();
		System.out.println("loanamount" + loanAmount);
		double result = balance + loanAmount;
		System.out.println("result" + result);
		c.setAccountbalance(result);
		customerService.updateCustomer(c);
		loan.setCustomer(c);
		System.out.println(loan.getCustomer().getAccountbalance());
		loanService.updateLoan(loan);
	}

	/** The list comparator. */
	public static Comparator<Loan> listComparator = new Comparator<Loan>() {
		@Override
		public int compare(Loan l1, Loan l2) {
			Integer id1 = l1.getLoanId();
			Integer id2 = l2.getLoanId();
			return id1.compareTo(id2);
		}
	};
}
