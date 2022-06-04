package br.com.studenttracker.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.studenttracker.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public CustomerDAOImpl() {
		System.out.println(sessionFactory);
	}
	
	@Override
	public List<Customer> getAllCustomers() {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<Customer> query = session
				.createQuery("from Customer", Customer.class);
		
		return query.getResultList();		
	}

}
