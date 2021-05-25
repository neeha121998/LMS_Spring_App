package com.mph.entity;

import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

// TODO: Auto-generated Javadoc
/**
 * The Class Loan.
 * @author Mushahid
 */
@Entity
public class Loan {

	/** The loan id. */
	@Id
	@GeneratedValue
	private int loanId;
	
	/** The loantype. */
	private String loantype;
	
	/** The term. */
	private int term;
	
	/** The surety. */
	@Lob
	private String surety;
	
	/** The loan date. */
	@Temporal(TemporalType.DATE)
	private Calendar loanDate;
	
	/** The status. */
	private String status;
	
	/** The full amount. */
	private double fullAmount;
	
	/** The interest. */
	private double interest;
	
	/** The loan amount. */
	private double loanAmount;
	
	/** The rateofinterest. */
	private int rateofinterest;
	
	/** The customer. */
	@ManyToOne
	@JoinColumn(name = "customerId", referencedColumnName = "CUSTOMERID")
	private Customer customer;

	/**
	 * Instantiates a new loan.
	 */
	public Loan() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new loan.
	 *
	 * @param loanId the loan id
	 * @param loantype the loantype
	 * @param term the term
	 * @param surety the surety
	 * @param loanDate the loan date
	 * @param status the status
	 * @param fullAmount the full amount
	 * @param interest the interest
	 * @param loanAmount the loan amount
	 * @param rateofinterest the rateofinterest
	 * @param customer the customer
	 */
	public Loan(int loanId, String loantype, int term, String surety, Calendar loanDate, String status,
			double fullAmount, double interest, double loanAmount, int rateofinterest, Customer customer) {
		super();
		this.loanId = loanId;
		this.loantype = loantype;
		this.term = term;
		this.surety = surety;
		this.loanDate = loanDate;
		this.status = status;
		this.customer = customer;
		this.fullAmount = fullAmount;
		this.interest = interest;
		this.loanAmount = loanAmount;
		this.rateofinterest = rateofinterest;
	}

	/**
	 * Gets the loan id.
	 *
	 * @return the loan id
	 */
	public int getLoanId() {
		return loanId;
	}

	/**
	 * Sets the loan id.
	 *
	 * @param loanId the new loan id
	 */
	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}

	/**
	 * Gets the loantype.
	 *
	 * @return the loantype
	 */
	public String getLoantype() {
		return loantype;
	}

	/**
	 * Sets the ltype.
	 *
	 * @param loantype the new ltype
	 */
	public void setLtype(String loantype) {
		this.loantype = loantype;
	}

	/**
	 * Gets the term.
	 *
	 * @return the term
	 */
	public int getTerm() {
		return term;
	}

	/**
	 * Sets the term.
	 *
	 * @param term the new term
	 */
	public void setTerm(int term) {
		this.term = term;
	}

	/**
	 * Gets the surety.
	 *
	 * @return the surety
	 */
	public String getSurety() {
		return surety;
	}

	/**
	 * Sets the surety.
	 *
	 * @param surety the new surety
	 */
	public void setSurety(String surety) {
		this.surety = surety;
	}

	/**
	 * Gets the loan date.
	 *
	 * @return the loan date
	 */
	public Calendar getLoanDate() {
		return loanDate;
	}

	/**
	 * Sets the loan date.
	 *
	 * @param loanDate the new loan date
	 */
	public void setLoanDate(Calendar loanDate) {
		this.loanDate = loanDate;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Gets the customer.
	 *
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * Sets the customer.
	 *
	 * @param customer the new customer
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * Gets the full amount.
	 *
	 * @return the full amount
	 */
	public double getFullAmount() {
		return fullAmount;
	}

	/**
	 * Sets the full amount.
	 *
	 * @param fullAmount the new full amount
	 */
	public void setFullAmount(double fullAmount) {
		this.fullAmount = fullAmount;
	}

	/**
	 * Gets the interest.
	 *
	 * @return the interest
	 */
	public double getInterest() {
		return interest;
	}

	/**
	 * Sets the interest.
	 *
	 * @param interest the new interest
	 */
	public void setInterest(double interest) {
		this.interest = interest;
	}

	/**
	 * Gets the loan amount.
	 *
	 * @return the loan amount
	 */
	public double getLoanAmount() {
		return loanAmount;
	}

	/**
	 * Sets the loan amount.
	 *
	 * @param loanAmount the new loan amount
	 */
	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	/**
	 * Gets the rateofinterest.
	 *
	 * @return the rateofinterest
	 */
	public int getRateofinterest() {
		return rateofinterest;
	}

	/**
	 * Sets the rateofinterest.
	 *
	 * @param rateofinterest the new rateofinterest
	 */
	public void setRateofinterest(int rateofinterest) {
		this.rateofinterest = rateofinterest;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Loan [loanId=" + loanId + ", loantype=" + loantype + ", term=" + term + ", surety=" + surety
				+ ", loanDate=" + loanDate + ", status=" + status + ", fullAmount=" + fullAmount + ", interest="
				+ interest + ", loanAmount=" + loanAmount + ", rateofinterest=" + rateofinterest + ", customer="
				+ customer + "]";
	}

}