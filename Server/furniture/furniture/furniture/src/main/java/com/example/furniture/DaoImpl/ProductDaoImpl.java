package com.example.furniture.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.furniture.Dao.ProductDao;
import com.example.furniture.DbUtil.DBUtil;
import com.example.furniture.Model.Product;


@Repository
public class ProductDaoImpl implements ProductDao {
	@Autowired
	static List<Product> productlist = new ArrayList();
	Connection connection;
	Product currentProd = new Product();
	
	public ProductDaoImpl() {
		connection = DBUtil.getConnection();
		System.out.println("Connection ---" + connection);
	}
	
	@Override
	public List<Product> ViewAllProducts() {

		System.out.println("Inside viewAll product");
		
		productlist.clear();
		try {
			PreparedStatement stmt = connection.prepareStatement("select * from product");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Product prod = new Product();
				System.out.println("Inside while");
				prod.setProductID(rs.getInt(1));
				prod.setProductName(rs.getString(2));
				prod.setProductPrice(rs.getInt(3));
				prod.setProductDescription(rs.getString(4));
				prod.setProductImage(rs.getString(5));
				prod.setCategoryID(rs.getInt(6));
		
				
				System.out.println("Inside while-2");
				productlist.add(prod);
				System.out.println(productlist);
			}
		} catch (Exception e) {
		}
		return productlist;
	}
	

	@Override
	public List<Product> ViewAllProductsById(int categoryID) {

		System.out.println("Inside viewAll product");
		
		productlist.clear();
		try {
			PreparedStatement stmt = connection.prepareStatement("select * from product where categoryid="+categoryID);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Product prod = new Product();
				System.out.println("Inside while");
				prod.setProductID(rs.getInt(1));
				prod.setProductName(rs.getString(2));
				prod.setProductPrice(rs.getInt(3));
				prod.setProductDescription(rs.getString(4));
				prod.setProductImage(rs.getString(5));
				prod.setCategoryID(rs.getInt(6));
		
				
				System.out.println("Inside while-2");
				productlist.add(prod);
				System.out.println(productlist);
			}
		} catch (Exception e) {
		}
		return productlist;
	}


	@Override
	public void addProduct(Product product) {
		System.out.println("Inside addProduct");
		int productid = product.getProductID();
		String productname = product.getProductName();
		int productprice =product.getProductPrice();
		String productdescription = product.getProductDescription();
		String productimage = product.getProductImage();
		int categoryid= product.getCategoryID();

		String InsertProdQuery = "INSERT INTO PRODUCT(productid,productname,productprice,productdescription,productimage,categoryid) "
				+ "VALUES('" + productid + "','" + productname + "','" + productprice + "','" + productdescription + "','" + productimage + "','" + categoryid + "')";

		try {

			PreparedStatement stmt = connection.prepareStatement(InsertProdQuery);
			stmt.executeUpdate();
			System.out.println("Product Added Successfully");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}

		
	}

	@Override
	public void deleteProduct(int id) {
		System.out.println("Inside deleteProduct");
		String query = "DELETE FROM PRODUCT WHERE productid ='" + id + "';";

		try {
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.executeUpdate();
			System.out.println("Product Deleted Successfully");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Product Delete FAILED");
		}
		
	}

	@Override
	public void updateProduct(Product product) {
		System.out.println("Inside updateProduct");
		int productid = product.getProductID();
		String productname = product.getProductName();
		int productprice =product.getProductPrice();
		String productdescription = product.getProductDescription();
		String productimage = product.getProductImage();
		int categoryid= product.getCategoryID();

		String UpdateQuery = "UPDATE  PRODUCT SET productname='" + productname + "' WHERE productid='"
				+ productid + "';";

		try {
			PreparedStatement stmt = connection.prepareStatement(UpdateQuery);
			stmt.executeUpdate();
			System.out.println("Product Updated Successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Product Update Failed");
			System.out.println(e);

		}
		
	}


	
}
