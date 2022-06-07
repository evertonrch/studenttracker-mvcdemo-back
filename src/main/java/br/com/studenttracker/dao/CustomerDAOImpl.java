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

	@Override
	public void deleteCustomer(Long id) {
		
		Session session = sessionFactory.getCurrentSession();
		session.createQuery("DELETE FROM Customer WHERE id = :id")
			.setParameter("id", id)
			.executeUpdate();		
	}

	@Override
	public List<Customer> searchCustomers(String name) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<Customer> query = null;
		
		if(name != null && name.trim().length() > 0) {
			query = session.createQuery("FROM Customer WHERE LOWER(firstName) "
					+ "LIKE :name OR LOWER(lastName) LIKE :name", Customer.class)
					.setParameter("name", "%" + name.toLowerCase() + "%");
		}
		else {
			query = session.createQuery("FROM Customer", Customer.class);
		}
		
		return query.getResultList();
	}

}
