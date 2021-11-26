package com.example.furniture.Model;

public class Customer {
 
	int customerID;
	String customerName;
	String dateofbirth;
	long phone;
	String email;
	String address;
	String username;
	String password;
	
	
	
	
	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", customerName=" + customerName + ", dateofbirth=" + dateofbirth
				+ ", phone=" + phone + ", email=" + email + ", address=" + address + ", username=" + username
				+ ", password=" + password + "]";
	}
	public Customer() {
		super();
	}
	public Customer(int customerID, String customerName, String dateofbirth, long phone, String email, String address,
			String username, String password) {
		super();
		this.customerID = customerID;
		this.customerName = customerName;
		this.dateofbirth = dateofbirth;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.username = username;
		this.password = password;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getDateofbirth() {
		return dateofbirth;
	}
	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
