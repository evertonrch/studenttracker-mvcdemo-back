package br.com.studenttracker.dao;

import java.util.List;

import br.com.studenttracker.entity.Customer;

public interface CustomerDAO {

	List<Customer> getAllCustomers();

	void saveCustomer(Customer customer);

	Customer getCustomer(Long id);

	void deleteCustomer(Long id);

	List<Customer> searchCustomers(String name);
}
