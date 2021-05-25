package com.mph.dao;

import java.util.List;

import com.mph.entity.Loan;


/**
 * The Interface LoanDao.
 */
public interface LoanDao {
	
	/**
	 * Creates the loan.
	 *
	 * @param loan the loan
	 */
	public void createLoan(Loan loan);

	/**
	 * Gets the loan list.
	 *
	 * @param customerId the customer id
	 * @return the loan list
	 */
	public List<Loan> getLoanList(String customerId);

	/**
	 * Gets the loan.
	 *
	 * @param loanId the loan id
	 * @return the loan
	 */
	public Loan getLoan(int loanId);

	/**
	 * Update loan.
	 *
	 * @param loan the loan
	 */
	public void updateLoan(Loan loan);

	/**
	 * Delete loan.
	 *
	 * @param loanId the loan id
	 */
	public void deleteLoan(int loanId);

	/**
	 * Gets the pending loans.
	 *
	 * @return the pending loans
	 */
	public List<Loan> getPendingLoans();

	/**
	 * Gets the non pending loans.
	 *
	 * @return the non pending loans
	 */
	public List<Loan> getNonPendingLoans();

}
