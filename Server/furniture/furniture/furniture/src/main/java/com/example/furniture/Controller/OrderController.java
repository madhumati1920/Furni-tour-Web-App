package com.example.furniture.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.furniture.DaoImpl.OrderDaoImpl;
import com.example.furniture.Model.Order;

@CrossOrigin("http://localhost:4200")
@RestController
public class OrderController {
	@Autowired
	OrderDaoImpl orderObj;
	
	@GetMapping("/order")
	public List getOrder() {
		return orderObj.ViewAllOrders();
	}
	
	@RequestMapping(value = "/addorder", method = RequestMethod.POST)
	public void addOrder(@RequestBody Order order){

		orderObj.addOrder(order);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/deleteorder/{id}")
	public void deleteOrder(@PathVariable int id) {
		orderObj.deleteOrder(id);
	}
	
	
	 
	
}
