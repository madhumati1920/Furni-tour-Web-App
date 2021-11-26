package com.example.furniture.Model;

public class OrderDetails {
	int total;
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public OrderDetails(int total) {
		super();
		this.total = total;
	}

	public OrderDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "OrderDetails [total=" + total + "]";
	}

}
