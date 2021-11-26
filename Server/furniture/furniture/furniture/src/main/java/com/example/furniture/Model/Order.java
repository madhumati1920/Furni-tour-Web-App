package com.example.furniture.Model;

public class Order {
	int orderID;
	String orderDate;
	int customerID;
	int total;
	
	
	public Order(int orderID, int customerID, int total) {
		super();
		this.orderID = orderID;
//		this.orderDate = orderDate;
		this.customerID = customerID;
		this.total = total;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	
	
	
	
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	@Override
	public String toString() {
		return "Order [orderID=" + orderID + ", orderDate=" + orderDate + ", customerID=" + customerID + ", total="
				+ total + "]";
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	

}