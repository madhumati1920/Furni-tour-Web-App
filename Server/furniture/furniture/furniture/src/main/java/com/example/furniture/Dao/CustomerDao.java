package com.example.furniture.Dao;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.example.furniture.Model.Customer;


@Repository
public interface CustomerDao {

	 public List<Customer> ViewAllCustomers();

	 public void addCustomer(Customer customer);

	 public	void deleteCustomer(int id);

	 public	void updateCustomer(Customer customer);

	 public void changePassword(String password);

	int loginValidation(String username, String password);


}
