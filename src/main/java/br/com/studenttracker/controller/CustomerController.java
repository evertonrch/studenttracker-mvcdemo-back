package br.com.studenttracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.studenttracker.entity.Customer;
import br.com.studenttracker.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String list(Model model) {
		
		List<Customer> customers = customerService.getAllCustomers();
		
		model.addAttribute("customers", customers);

		return "list-customer";
	}

}
