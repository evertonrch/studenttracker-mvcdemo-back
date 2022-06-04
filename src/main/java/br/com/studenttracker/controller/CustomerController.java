package br.com.studenttracker.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.studenttracker.dao.CustomerDAO;
import br.com.studenttracker.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	private CustomerDAO customerDao;
	
	@GetMapping("/list")
	public String list(Model model) {
		
		List<Customer> customers = customerDao.getAllCustomers();
		
		model.addAttribute("customers", customers);

		return "list-customer";
	}

}
