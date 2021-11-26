package com.example.furniture.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.furniture.Dao.CustomerDao;
import com.example.furniture.DbUtil.DBUtil;
import com.example.furniture.Model.Customer;



@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	static List<Customer> customerlist = new ArrayList();

	Connection connection;
	Customer currentCust = new Customer();

	public CustomerDaoImpl() {
		connection = DBUtil.getConnection();
		System.out.println("Connection ---" + connection);
	}

	public int getCustomerID()
	{
		System.out.println(currentCust.getCustomerID());
		return currentCust.getCustomerID();
		
	}
 
	
	@Override
	public List<Customer> ViewAllCustomers() {
		customerlist.clear();
		System.out.println("Inside viewAll customer");
		try {
			PreparedStatement stmt = connection.prepareStatement("select * from customer");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Customer cust = new Customer();
				System.out.println("Inside while");
				cust.setCustomerID(rs.getInt(1));
				cust.setCustomerName(rs.getString(2));
				cust.setDateofbirth(rs.getString(3));
				cust.setPhone(rs.getInt(4));
				cust.setEmail(rs.getString(5));
				cust.setAddress(rs.getString(6));
				cust.setUsername(rs.getString(7));
				cust.setPassword(rs.getString(8));
				System.out.println("Inside while-2");
				customerlist.add(cust);
				System.out.println(customerlist);
			}
		} catch (Exception e) {
		}
		return customerlist;
	}

	
	@Override
	public void addCustomer(Customer customer) {
		System.out.println("Inside addCustomer");

		int customerid = customer.getCustomerID();
		String customername = customer.getCustomerName();
		String dateofbirth = customer.getDateofbirth();
		int phone = (int) customer.getPhone();
		String email = customer.getEmail();
		String address = customer.getAddress();
		String username = customer.getUsername();
		String password = customer.getPassword();

		String SignUpQuery = "INSERT INTO CUSTOMER(customername,dateofbirth,phone,email,address,username,password) "
				+ "VALUES('" + customername + "','" + dateofbirth + "','" + phone + "','" + email
				+ "','" + address + "','" + username + "','" + password + "')";

		try {

			PreparedStatement stmt = connection.prepareStatement(SignUpQuery);
			stmt.executeUpdate();
			System.out.println("Customer Added Successfully");

		} catch (SQLException e) {
			 
			System.out.println(e);
		}

	}

	
	@Override
	public void deleteCustomer(int id) {
		System.out.println("Inside deleteCustomer");
		String query = "DELETE FROM CUSTOMER WHERE customerid ='" + id + "';";

		try {
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.executeUpdate();
			System.out.println("Customer Deleted Successfully");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Customer Delete FAILED");
		}

	}

	
	@Override
	public void updateCustomer(Customer customer) {
		System.out.println("Inside UpdateCustomer");
		int customerid = customer.getCustomerID();
		String customername = customer.getCustomerName();
		String username = customer.getUsername();
		String email = customer.getEmail();
		long phone = customer.getPhone();
		String address = customer.getAddress();

		String UpdateQuery = "UPDATE  CUSTOMER SET customername='" + customername + "',username='" + username
				+ "',email='" + email + "',address='" + address + "',phone='" + phone + "' WHERE customerid='"
				+ customerid + "';";

		try {
			PreparedStatement stmt = connection.prepareStatement(UpdateQuery);
			stmt.executeUpdate();
			System.out.println("Customer Updated Successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Customer Update Failed");
			System.out.println(e);

		}

	}

	
	@Override
	public void changePassword(String password) {
		System.out.println("Inside changepassword");

		String Updatepass = "UPDATE  CUSTOMER SET password='" + password + "' WHERE customerid='"
				+ currentCust.getCustomerID() + "';";

		try {
			PreparedStatement stmt = connection.prepareStatement(Updatepass);
			stmt.executeUpdate();
			System.out.println("Password Updated Successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("password Update Failed");
			System.out.println(e);

		}

	}
	
	
	
	@Override
	public int loginValidation(String username, String password) {
		System.out.println(password+" "+username);
		int flag = 0;
	 
		System.out.println("Inside viewAll customer");
		try {

			PreparedStatement stmt = connection
					.prepareStatement("select * from customer where username='" + username + "'");
			System.out.println("Inside viewAll customersdfsdfsdvsdvsdvsd");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				
				System.out.print(rs.getString(7) + " " + rs.getString(8));

				if (rs.getString(7).equals(username) && rs.getString(8).equals(password)) {
					System.out.println("Inside while");

					currentCust.setCustomerID(rs.getInt(1));
					currentCust.setCustomerName(rs.getString(2));
					currentCust.setDateofbirth(rs.getString(3));

					currentCust.setPhone(rs.getInt(4));
					currentCust.setEmail(rs.getString(5));
					currentCust.setAddress(rs.getString(6));

					currentCust.setUsername(rs.getString(7));
					currentCust.setPassword(rs.getString(8));

					System.out.println("Login Successfully");
					flag = 1;
				} else {
					System.out.println("enter Valid Credentials");
				}
			}
		} catch (SQLException e) {
			System.out.println(e);
		}

		System.out.print(flag);
		return flag;
	}
	

}
