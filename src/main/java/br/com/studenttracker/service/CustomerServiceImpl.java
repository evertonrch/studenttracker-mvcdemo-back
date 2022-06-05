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

}
