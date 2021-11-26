package com.example.furniture.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.furniture.DaoImpl.CustomerDaoImpl;
import com.example.furniture.Model.Customer;


@CrossOrigin("http://localhost:4200")
@RestController
public class CustomerController {
	@Autowired
	CustomerDaoImpl customerObj;
	
	
	@CrossOrigin("http://localhost:4200")
	@GetMapping("/customer")
	public List getCustomer() {
		return customerObj.ViewAllCustomers();
	}
	
	@RequestMapping(value = "/addcustomer", method = RequestMethod.POST)
	public void addCustomer(@RequestBody Customer customer){

		customerObj.addCustomer(customer);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/delectcustomer/{id}")
	public void deleteCustomer(@PathVariable int id) {
		customerObj.deleteCustomer(id);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/update/customer")
	public void updateCustomer(@RequestBody Customer customer) {
		customerObj.updateCustomer(customer);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/change/customer/{password}")
	public void updatePassword(@PathVariable("password") String password) {
		customerObj.changePassword(password);
	}
	
	@GetMapping("customer/{custUserName}/{custPassword}")
	public int CustomerLogin(@PathVariable("custUserName") String custUserName,
			@PathVariable("custPassword") String custPassword) {
		int flag = customerObj.loginValidation(custUserName, custPassword);
		if (flag == 0) {
			return flag;
		}
		return flag;
	}
	 
	
}
