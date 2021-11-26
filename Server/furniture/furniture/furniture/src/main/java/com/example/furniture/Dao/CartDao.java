package com.example.furniture.Dao;

import java.util.List;

import com.example.furniture.Model.Cart;
import com.example.furniture.Model.CartDetails;
import com.example.furniture.Model.OrderDetails;


public interface CartDao {

	public List<Cart> ViewCart();
	public void addOrderDetail(Cart cart);

	public void deleteOrderDetail(int id);

	public void updateOrderDetail(Cart cart);
//	public  List<Cart> viewCart(int orderid);
//	public   void removeFromCart(int productid, int orderid);
//	public   void updateCart(int qty, int productid, int orderid);
//	public   int createOrder(int custid);
//	public   void addToCart(int productid, int qty);
//	public   void payOut();
//	
	public void addToCart(int prodid, int qty);

	public void createOrder(int custid);
	public List<CartDetails> getCartDetails();
	
	public List<OrderDetails> gettotal();
	
	public void deletecartproduct(int id);
//	public void deleteOrderDetail();
	

}
