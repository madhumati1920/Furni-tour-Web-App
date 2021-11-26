package com.example.furniture.Dao;

import java.util.List;

import com.example.furniture.Model.Product;



public interface ProductDao {

	public List<Product> ViewAllProducts();
	public void addProduct(Product product);

	public void deleteProduct(int id);

	public void updateProduct(Product product);
	public List<Product> ViewAllProductsById(int categoryID);
	
	
	

}
