package com.mph.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;

// TODO: Auto-generated Javadoc
/**
 * The Class Customer.
 * @author Swapna
 */
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "P_TYPE")
@Entity(name = "CUSTOMER")
public class Customer {
	
	/** The customer id. */
	@Id

	private String customerId;
	
	/** The first name. */
	private String firstName;
	
	/** The last name. */
	private String lastName;
	
	/** The age. */
	private int age;
	
	/** The address. */
	@Embedded
	private Address address;
	
	/** The account number. */
	private long accountNumber;
	
	/** The phone number. */
	private long phoneNumber;
	
	/** The aadhar number. */
	private long aadharNumber;
	
	/** The email id. */
	private String emailId;
	
	/** The password. */
	private String password;
	
	/** The accountbalance. */
	private double accountbalance;
	
	/** The loan. */
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Loan> loan;

	/**
	 * Instantiates a new customer.
	 */
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new customer.
	 *
	 * @param customerId the customer id
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param age the age
	 * @param address the address
	 * @param accountNumber the account number
	 * @param phoneNumber the phone number
	 * @param aadharNumber the aadhar number
	 * @param emailId the email id
	 * @param password the password
	 * @param accountbalance the accountbalance
	 * @param loan the loan
	 */
	public Customer(String customerId, String firstName, String lastName, int age, Address address, long accountNumber,
			long phoneNumber, long aadharNumber, String emailId, String password, double accountbalance,
			List<Loan> loan) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.address = address;
		this.accountNumber = accountNumber;
		this.phoneNumber = phoneNumber;
		this.aadharNumber = aadharNumber;
		this.emailId = emailId;
		this.password = password;
		this.accountbalance = accountbalance;
		this.loan = loan;
	}

	/**
	 * Gets the customer id.
	 *
	 * @return the customer id
	 */
	public String getCustomerId() {
		return customerId;
	}

	/**
	 * Sets the customer id.
	 *
	 * @param customerId the new customer id
	 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the age.
	 *
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Sets the age.
	 *
	 * @param age the new age
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * Gets the address.
	 *
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * Sets the address.
	 *
	 * @param address the new address
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * Gets the account number.
	 *
	 * @return the account number
	 */
	public long getAccountNumber() {
		return accountNumber;
	}

	/**
	 * Sets the account number.
	 *
	 * @param accountNumber the new account number
	 */
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * Gets the phone number.
	 *
	 * @return the phone number
	 */
	public long getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Sets the phone number.
	 *
	 * @param phoneNumber the new phone number
	 */
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Gets the aadhar number.
	 *
	 * @return the aadhar number
	 */
	public long getAadharNumber() {
		return aadharNumber;
	}

	/**
	 * Sets the aadhar number.
	 *
	 * @param aadhar the new aadhar number
	 */
	public void setAadharNumber(long aadhar) {
		this.aadharNumber = aadhar;
	}

	/**
	 * Gets the email id.
	 *
	 * @return the email id
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * Sets the email id.
	 *
	 * @param emailId the new email id
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the accountbalance.
	 *
	 * @return the accountbalance
	 */
	public double getAccountbalance() {
		return accountbalance;
	}

	/**
	 * Sets the accountbalance.
	 *
	 * @param accountbalance the new accountbalance
	 */
	public void setAccountbalance(double accountbalance) {
		this.accountbalance = accountbalance;
	}

	/**
	 * Gets the loan.
	 *
	 * @return the loan
	 */
	public List<Loan> getLoan() {
		return loan;
	}

	/**
	 * Sets the loan.
	 *
	 * @param loan the new loan
	 */
	public void setLoan(List<Loan> loan) {
		this.loan = loan;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName + ", age="
				+ age + ", address=" + address + ", accountNumber=" + accountNumber + ", phoneNumber=" + phoneNumber
				+ ", aadharNumber=" + aadharNumber + ", emailId=" + emailId + ", password=" + password
				+ ", accountbalance=" + accountbalance + ", loan=" + loan + "]";
	}

}
