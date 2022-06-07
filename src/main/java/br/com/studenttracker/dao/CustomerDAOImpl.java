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
	
	@Override
	public List<Customer> getAllCustomers() {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<Customer> query = session
				.createQuery("FROM Customer ORDER BY firstName", Customer.class);
		
		return query.getResultList();		
	}

	@Override
	public void saveCustomer(Customer customer) {
		
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(customer);
	}

	@Override
	public Customer getCustomer(Long id) {
		
		Session session = sessionFactory.getCurrentSession();
		return session.get(Customer.class, id);
	}

}
