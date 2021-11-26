package com.example.furniture.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.furniture.Dao.CategoryDao;
import com.example.furniture.DbUtil.DBUtil;
import com.example.furniture.Model.Category;



@Repository
public class CategoryDaoImpl implements CategoryDao {
	@Autowired
	static List<Category> categorylist = new ArrayList();
	Connection connection;
	Category currentCat = new Category();
	
	public CategoryDaoImpl() {
		connection = DBUtil.getConnection();
		System.out.println("Connection ---" + connection);
	}
	
	@Override
	public List<Category> ViewAllCategory() {

		System.out.println("Inside viewAll category");
		categorylist.clear();
		try {
			PreparedStatement stmt = connection.prepareStatement("select * from category");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Category cat = new Category();
				System.out.println("Inside while");
				
				cat.setCategoryID(rs.getInt(1));
				cat.setCategoryName(rs.getString(2));
				cat.setCategoryImage(rs.getString(3));
				
				System.out.println("Inside while-2");
				categorylist.add(cat);
				System.out.println(categorylist);
			}
		} catch (Exception e) {
		}
		return categorylist;
	}
	
	@Override
	public void addCategory(Category category) {
		System.out.println("Inside addCategory");
		int categoryid = category.getCategoryID();
		String categoryname = category.getCategoryName();
		String categoryimage = category.getCategoryImage();

		String InsertCatQuery = "INSERT INTO CATEGORY(categoryname,categoryimage) "
				+ "VALUES('" + categoryname + "','" + categoryimage + "')";

		try {

			PreparedStatement stmt = connection.prepareStatement(InsertCatQuery);
			stmt.executeUpdate();
			System.out.println("Category Added Successfully");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
	}

	@Override
	public void deleteCategory(int id) {
		System.out.println("Inside deleteCategory");
		String query = "DELETE FROM CATEGORY WHERE categoryid ='" + id + "';";

		try {
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.executeUpdate();
			System.out.println("Category Deleted Successfully");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Category Delete FAILED");
		}
		
	}

	@Override
	public void updateCategory(Category category) {
		System.out.println("Inside UpdateCategory");
		int categoryid = category.getCategoryID();
		String categoryname = category.getCategoryName();
		String categoryimage = category.getCategoryImage();

		String UpdateQuery = "UPDATE  CATEGORY SET ( categoryname='" + categoryname + "', categoryimage='" + categoryimage + "') WHERE categoryid='"
				+ categoryid + "';";

		try {
			PreparedStatement stmt = connection.prepareStatement(UpdateQuery);
			stmt.executeUpdate();
			System.out.println("Category Updated Successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Category Update Failed");
			System.out.println(e);

		}
		
	}

	

	
}
