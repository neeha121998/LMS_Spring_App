package com.mph.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mph.entity.Loan;

// TODO: Auto-generated Javadoc
/**
 * The Class LoanDaoImpl.
 */
@Repository
@Transactional
public class LoanDaoImpl implements LoanDao {

	/** The session factory. */
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Gets the session.
	 *
	 * @return the session
	 */
	protected Session getSession() {

		return sessionFactory.getCurrentSession();
	}

	/**
	 * Creates the loan.
	 * @author Mohit
	 * @param loan the loan
	 */
	@Override
	public void createLoan(Loan loan) {

		getSession().saveOrUpdate(loan);
	}

	/**
	 * Gets the loan list.
	 * @author NavyaSree
	 * @param customerId the customer id
	 * @return the loan list
	 */
	@Override
	public List<Loan> getLoanList(String customerId) {

		Query query = getSession().createQuery("select loan from Loan loan where customerId=:customerId");
		query.setParameter("customerId", customerId);
		List<Loan> loanList = query.list();
		return loanList;
	}

	/**
	 * Gets the loan.
	 * @author NavyaSree
	 * @param loanId the loan id
	 * @return the loan
	 */
	@Override
	public Loan getLoan(int loanId) {

		Criteria criteria = getSession().createCriteria(Loan.class);
		criteria.add(Restrictions.eq("loanId", loanId));
		Loan loanObject = (Loan) criteria.uniqueResult();
		System.out.println(loanObject);
		return loanObject;
	}

	/**
	 * Update loan.
	 * @author Mushahid
	 * @param loan the loan
	 */
	@Override
	public void updateLoan(Loan loan) {

		getSession().update(loan);
	}

	/**
	 * Delete loan.
	 *@author Mushahid
	 * @param loanId the loan id
	 */
	@Override
	public void deleteLoan(int loanId) {

		Query query = getSession().createQuery("delete from Loan where loanId=:loanId");
		query.setParameter("loanId", loanId);
		int n = query.executeUpdate();
	}

	/**
	 * Gets the pending loans.
	 *@author Neeha
	 * @return the pending loans
	 */
	@Override
	public List<Loan> getPendingLoans() {

		Criteria criteria = getSession().createCriteria(Loan.class);
		criteria.add(Restrictions.eq("status", "pending"));
		List<Loan> loanList = criteria.list();
		return loanList;
	}

	/**
	 * Gets the non pending loans.
	 * @author Neeha
	 * @return the non pending loans
	 */
	@Override
	public List<Loan> getNonPendingLoans() {
		Criteria criteria = getSession().createCriteria(Loan.class);
		criteria.add(Restrictions.not(Restrictions.eq("status", "pending")));
		List<Loan> loanList = criteria.list();
		return loanList;
	}

}