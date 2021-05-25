package com.mph.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mph.dao.LoanDao;
import com.mph.entity.Loan;

// TODO: Auto-generated Javadoc
/**
 * The Class LoanServiceImpl.
 * @author Navyasree
 */
@Service
@Transactional
public class LoanServiceImpl implements LoanService {
	
	/** The loan dao. */
	@Autowired
	LoanDao loanDao;

	/**
	 * Creates the loan.
	 *
	 * @param loan the loan
	 */
	@Override
	public void createLoan(Loan loan) {
		loanDao.createLoan(loan);

	}

	/**
	 * Gets the loan list.
	 *
	 * @param customerId the customer id
	 * @return the loan list
	 */
	@Override
	public List<Loan> getLoanList(String customerId) {
		return loanDao.getLoanList(customerId);
	}

	/**
	 * Gets the loan.
	 *
	 * @param loanId the loan id
	 * @return the loan
	 */
	@Override
	public Loan getLoan(int loanId) {

		return loanDao.getLoan(loanId);
	}

	/**
	 * Update loan.
	 *
	 * @param loan the loan
	 */
	@Override
	public void updateLoan(Loan loan) {
		loanDao.updateLoan(loan);

	}

	/**
	 * Delete loan.
	 *
	 * @param loanId the loan id
	 */
	@Override
	public void deleteLoan(int loanId) {
		loanDao.deleteLoan(loanId);

	}

	/**
	 * Gets the pending loans.
	 *
	 * @return the pending loans
	 */
	@Override
	public List<Loan> getPendingLoans() {
		return loanDao.getPendingLoans();
	}

	/**
	 * Gets the non pending loans.
	 *
	 * @return the non pending loans
	 */
	@Override
	public List<Loan> getNonPendingLoans() {
		return loanDao.getNonPendingLoans();
	}

}
