package com.suni.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.suni.springdemo.entity.Customer;
import com.suni.springdemo.service.CustomerService;
import com.suni.springdemo.util.SortUtils;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//injecting the customerService in the controller
	@Autowired
	CustomerService customerService;
	
	
	@GetMapping("/list")
	public String listCustomers(Model theModel,@RequestParam(required=false) String sort) {
		
		//get the customer from service
		List<Customer> theCustomers=null;
		
		if(sort != null) {
			int theSort=Integer.parseInt(sort);
			//sort based on param value
			theCustomers=customerService.getCustomers(theSort);
		}
		else {
			//default sort will be by first name
			theCustomers=customerService.getCustomers(SortUtils.FIRST_NAME);
		}
		//add the customer to model
		theModel.addAttribute("customers",theCustomers);
		
		
		
		return "list-customer";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		Customer theCustomer=new Customer();
		theModel.addAttribute("customer",theCustomer);
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		customerService.saveCustomer(theCustomer);
		return"redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId,Model theModel) {
		
		//get the customer from service
		Customer theCustomer=customerService.getCustomer(theId);
		
		//add the customer as the model attribute to pre-populate the form.
		theModel.addAttribute("customer",theCustomer);
		
		//send over to form
		return "customer-form";
		
	}
	
	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("customerId") int theId) {
		
		customerService.deleteCustomer(theId);
		
		
		return "redirect:/customer/list";
		
	}
}
