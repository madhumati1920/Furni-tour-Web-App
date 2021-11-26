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

import com.example.furniture.DaoImpl.ProductDaoImpl;
import com.example.furniture.Model.Product;

@CrossOrigin("http://localhost:4200")
@RestController
public class ProductController {
	@Autowired
	ProductDaoImpl productObj;
	
	@CrossOrigin("http://localhost:4200")
	@GetMapping("/product")
	public List getProduct() {
		return productObj.ViewAllProducts();
	}
	
	@GetMapping("/product/{id}")
	public List getProductbyid(@PathVariable int id) {
		return productObj.ViewAllProductsById(id);
	}
	
	@RequestMapping(value = "/add/product", method = RequestMethod.POST)
	public void addProduct(@RequestBody Product product){

		productObj.addProduct(product);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/delete/product/{id}")
	public void deleteProduct(@PathVariable int id) {
		productObj.deleteProduct(id);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/update/product")
	public void updateProduct(@RequestBody Product product) {
		productObj.updateProduct(product);
	}
	
	 
	
}
