package br.com.studenttracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@GetMapping("/showFormAdd")
	public String showFormAdd(Model model) {
		
		model.addAttribute("customer", new Customer());
		return "customer-add";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(Customer customer) {
		
		customerService.saveCustomer(customer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormUpdate")
	public String showFromUpdate(@RequestParam("customerId") Long id, Model model) {
		
		Customer customer = customerService.getCustomer(id);
		model.addAttribute("customer", customer);
		return "customer-add";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") Long id) {
		
		customerService.deleteCustomer(id);
		return "redirect:/customer/list";		
	}
	
	@GetMapping("/search")
	public String searchCostumers(@RequestParam("searchName") String name, Model model) {
		List<Customer> customers = customerService.searchCustomers(name);
		model.addAttribute("customers", customers);
		return "list-customer";		
	}

}
