package com.example.furniture.Model;

public class Cart {
	

	int customerid;
	int productid;
	int qty;
	int price;
	
	int orderid;
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	public Cart(int orderid, int customerid, int productid, int qty) {
		super();
		this.orderid = orderid;
		this.customerid = customerid;
		this.productid = productid;
		this.qty = qty;
		this.price = price;
	}
	
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Cart [orderid=" + orderid + ", customerid=" + customerid + ", productid=" + productid + ", qty=" + qty
				+ ", price=" + price + "]";
	}
	
	

}