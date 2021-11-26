package com.example.furniture.Model;

public class Category {
	int categoryID;
	String categoryName;
	String categoryImage;
	public Category(int categoryID, String categoryName, String categoryImage) {
		super();
		this.categoryID = categoryID;
		this.categoryName = categoryName;
		this.categoryImage = categoryImage;
	}
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Category [categoryID=" + categoryID + ", categoryName=" + categoryName + ", categoryImage="
				+ categoryImage + "]";
	}
	public int getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryImage() {
		return categoryImage;
	}
	public void setCategoryImage(String categoryImage) {
		this.categoryImage = categoryImage;
	}
	
	
	
	
	
}