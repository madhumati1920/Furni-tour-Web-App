package com.example.furniture.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.furniture.DaoImpl.CartDaoImpl;
import com.example.furniture.DaoImpl.CustomerDaoImpl;
import com.example.furniture.Model.Cart;
import com.example.furniture.Model.CartDetails;
import com.example.furniture.Model.OrderDetails;


@CrossOrigin("*")
@RestController
public class CartController {
	@Autowired
	CartDaoImpl orderdetailObj;
	
	@Autowired
	CustomerDaoImpl cust;
	
	@GetMapping("/userlogin")
	public int userlogin()
	{
		System.out.println(cust.getCustomerID());
		orderdetailObj.createOrder(cust.getCustomerID());
		return 1;
	}
	
	@DeleteMapping("/delectproductfromcart/{id}")
	public void deleteCustomer(@PathVariable int id) {
		orderdetailObj.deletecartproduct(id);
	}
	
	@GetMapping("/addCart/{id}/{qty}")
	public int addCart(@PathVariable ("id") int ProdId,@PathVariable ("qty") int qty)
	{
		orderdetailObj.addToCart(ProdId,qty);
		return 1;
	}
	
//	@GetMapping("/viewcartdeatails")
//	public List getOrderDetail() {
//		return orderdetailObj.ViewCart();
//	}
	
	@GetMapping("/mycart")
	public List<CartDetails> viewCart()
	{
		return orderdetailObj.getCartDetails();
	}
	
	@GetMapping("/carttotal")
	public List<OrderDetails> total()
	{
		return orderdetailObj.gettotal();
	}
	
 
//	
//	@RequestMapping(value = "/addproducttocart", method = RequestMethod.POST)
//	public void addOrderDetail(@RequestBody Cart orderdetail){
//
//		orderdetailObj.addOrderDetail(orderdetail);
//	}
//	
//	@RequestMapping(method=RequestMethod.DELETE,value="/delete/orderdetail/{id}")
//	public void deleteOrderDetail(@PathVariable int id) {
//		orderdetailObj.deleteOrderDetail(id);
//	}
//	
//	@RequestMapping(method=RequestMethod.PUT,value="/update/orderdetail")
//	public void updateOrderDetail(@RequestBody Cart orderdetail) {
//		orderdetailObj.updateOrderDetail(orderdetail);
//	}
}
