package com.suni.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.suni.springdemo.entity.Customer;
import com.suni.springdemo.util.SortUtils;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers(int sortField) {
		String theFieldName = null;
		// get the hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		//Query<Customer> theQuery = null;
		
		// if sortField=1 the first name 2-last name 3-email
		switch (sortField) {
		case SortUtils.FIRST_NAME:
			theFieldName="firstName";
			break;
		case SortUtils.LAST_NAME:
			theFieldName="lastName";
			break;
		case SortUtils.EMAIL:
			theFieldName="email";
			break;
		default:
			theFieldName="firstName";

		}
		
		String queryString="from Customer order by "+theFieldName;

		// Create query
		Query<Customer> theQuery = currentSession.createQuery(queryString, Customer.class);

		// get result list
		List<Customer> customers = theQuery.getResultList();

		// return list of customer

		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		// get current session
		Session currentSeeion = sessionFactory.getCurrentSession();

		// save the customer
		currentSeeion.saveOrUpdate(theCustomer);
		System.out.println(">>Saving or Updating customer" + theCustomer);
	}

	@Override
	public Customer getCustomer(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// read the database using primary key
		Customer theCustomer = currentSession.get(Customer.class, theId);

		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
//		Customer theCustomer=currentSession.get(Customer.class, theId);
//		currentSession.delete(theCustomer);
//		System.out.println(">>Deleting "+theCustomer);

		@SuppressWarnings("rawtypes")
		Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", theId);
		theQuery.executeUpdate();

	}

}
