package br.com.studenttracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.studenttracker.dao.CustomerDAO;
import br.com.studenttracker.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDAO customerDao;

	@Transactional
	@Override
	public List<Customer> getAllCustomers() {
		return customerDao.getAllCustomers();
	}

	@Transactional
	@Override
	public void saveCustomer(Customer customer) {
		customerDao.saveCustomer(customer);		
	}

	@Transactional
	@Override
	public Customer getCustomer(Long id) {
		return customerDao.getCustomer(id);
	}

	@Transactional
	@Override
	public void deleteCustomer(Long id) {
		customerDao.deleteCustomer(id);		
	}

}
