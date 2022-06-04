package br.com.studenttracker.controller;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@GetMapping("/list")
	public String list(Model model) {

		model.addAttribute("arrTest", Arrays.asList("Everton", "Marcos", "Pedro"));

		return "list-customer";
	}

}
