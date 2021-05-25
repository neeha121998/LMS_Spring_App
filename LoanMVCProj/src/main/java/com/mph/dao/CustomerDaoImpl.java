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

import com.mph.entity.Business;
import com.mph.entity.Customer;
import com.mph.entity.Employees;
import com.mph.entity.Student;

/**
 * The Class CustomerDaoImpl.
 */
@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao {

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
	 * Creates the customer.
	 * 
	 * @author Mohit
	 * @param customer the customer
	 */
	@Override
	public void createCustomer(Customer customer) {
		getSession().saveOrUpdate(customer);
		System.out.println("Customer Stored in DB Successfully !!!");
	}

	/**
	 * Gets the customer list.
	 * 
	 * @author Swapna
	 * @return the customer list
	 */
	@Override
	@Transactional
	public List<Customer> getCustomerList() {
		Query query = getSession().createQuery("select customer from CUSTOMER customer");
		List<Customer> customerList = query.list();
		return customerList;

	}

	/**
	 * Gets the customer.
	 * 
	 * @author Neeha
	 * @param customer the customer
	 * @return the customer
	 */
	@Override
	public Customer getCustomer(Customer customer) {
		Criteria criteria = getSession().createCriteria(Customer.class);
		System.out.println(customer.getCustomerId());
		criteria.add(Restrictions.eq("customerId", customer.getCustomerId()));
		Customer customerObject = (Customer) criteria.uniqueResult();
		System.out.println(customerObject);
		return customerObject;
	}

	/**
	 * Update customer.
	 *
	 * @param customer the customer
	 * @return the list
	 */
	@Override
	public List<Customer> updateCustomer(Customer customer) {
		System.out.println("update");
		getSession().update(customer);

		return getCustomerList();
	}

	/**
	 * Creates the student.
	 * 
	 * @author Mushahid
	 * @param student the student
	 */
	@Override
	public void createStudent(Student student) {
		getSession().saveOrUpdate(student);
		System.out.println("Student Stored in DB Successfully !!!");
	}

	/**
	 * Creates the employee.
	 * 
	 * @author Mushahid
	 * @param employees the employees
	 */
	@Override
	public void createEmployee(Employees employees) {
		getSession().saveOrUpdate(employees);
		System.out.println("Employee Stored in DB Successfully !!!");

	}

	/**
	 * Creates the business.
	 * 
	 * @author Mushahid
	 * @param business the business
	 */
	@Override
	public void createBusiness(Business business) {
		getSession().saveOrUpdate(business);
		System.out.println("Business Stored in DB Successfully !!!");

	}

	/**
	 * Delete customer.
	 *
	 * @param customerid the customerid
	 * @return the list
	 */
	@Override
	public List<Customer> deleteCustomer(String customerid) {
		Query query = getSession().createQuery("delete CUSTOMER customer where customerId =:customerId");
		query.setParameter("customerId", customerid);
		int noofrows = query.executeUpdate();
		if (noofrows > 0) {
			System.out.println("Deleted " + noofrows + "rows. ");
		}
		return getCustomerList();
	}

}
