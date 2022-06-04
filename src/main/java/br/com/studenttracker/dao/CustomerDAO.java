package br.com.studenttracker.dao;

import java.util.List;

import br.com.studenttracker.entity.Customer;

public interface CustomerDAO {

	List<Customer> getAllCustomers();
}
