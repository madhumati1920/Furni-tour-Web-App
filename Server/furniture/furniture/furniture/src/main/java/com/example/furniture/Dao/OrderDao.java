package com.example.furniture.Dao;

import java.util.List;

import com.example.furniture.Model.Order;


public interface OrderDao {

	public List<Order> ViewAllOrders();
	public void addOrder(Order order);

	public void deleteOrder(int id);
	public void updateOrder(Order order);
	
	

}
