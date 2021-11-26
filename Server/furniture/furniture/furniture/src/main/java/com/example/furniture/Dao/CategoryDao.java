package com.example.furniture.Dao;

import java.util.List;

import com.example.furniture.Model.Category;



public interface CategoryDao {

	public List<Category> ViewAllCategory();
	public void addCategory(Category category);

//	public int loginValidation(String username, String password);
	public void deleteCategory(int id);

	public void updateCategory(Category category);
	

}
