package com.example.furniture.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.furniture.Dao.CartDao;
import com.example.furniture.DbUtil.DBUtil;
import com.example.furniture.Model.Cart;
import com.example.furniture.Model.CartDetails;
import com.example.furniture.Model.OrderDetails;


@Repository
public class CartDaoImpl implements CartDao {

	@Autowired
	static List<Cart> cartlist = new ArrayList();

	Connection connection;
	int orderid = 0;
	int currentcustid;
	boolean orderinit = false;

	@Autowired
	static List<CartDetails> list1 = new ArrayList();

	@Autowired
	static List<OrderDetails> list2 = new ArrayList();
	
	public CartDaoImpl() {
		connection = DBUtil.getConnection();
		System.out.println("Connection ---" + connection);
	}
	
	@Override
	public List<Cart> ViewCart() {
		cartlist.clear();

		System.out.println("Inside viewAll orderdetailSYHYHB");
		try {
			PreparedStatement stmt = connection.prepareStatement("select * from furniture.carts");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Cart cartdetail = new Cart();

				System.out.println("Inside while");

				cartdetail.setProductid(rs.getInt(2));
				cartdetail.setCustomerid(rs.getInt(3));
				cartdetail.setOrderid(rs.getInt(1));
				cartdetail.setQty(rs.getInt(4));
				cartdetail.setPrice(rs.getInt(5));

				System.out.println("Inside while-2");
				cartlist.add(cartdetail);
				System.out.println(cartlist);
			}
		} catch (Exception e) {
		}
		return cartlist;
		
	}

	@Override
	public void addOrderDetail(Cart cart) {
		System.out.println("Inside addOrderDetail");
		int orderid = cart.getOrderid();
		int productid = cart.getProductid();
		int custid = cart.getCustomerid();
		int qty = cart.getQty();

		String InsertOrderDetailQuery = "INSERT INTO furniture.carts (productid,custid,orderid,qty) " + "VALUES('"
				+ productid + "','" + custid + "','" + orderid + "','" + qty + "')";

		try {
			PreparedStatement stmt = connection.prepareStatement(InsertOrderDetailQuery);
			stmt.executeUpdate();
			System.out.println("New Product added in cart");

		} catch (SQLException e) {

			System.out.println(e);
		}
	}

	@Override
	public void deleteOrderDetail(int id) {
		System.out.println("Inside deleteOrderDetail");
		String query = "DELETE FROM furniture.order WHERE orderid ='" + id + "';";

		try {
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.executeUpdate();
			System.out.println("OrderDetail Deleted Successfully");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("OrderDetail Delete FAILED");
		}
	}

	@Override
	public void updateOrderDetail(Cart cart) {
		System.out.println("Inside updateProduct");
		int productid = cart.getProductid();
		int qty = cart.getQty();

		String UpdateQuery = "UPDATE  furniture.carts SET qty='" + qty + "' WHERE productid='" + productid + "';";

		try {
			PreparedStatement stmt = connection.prepareStatement(UpdateQuery);
			stmt.executeUpdate();
			System.out.println("cart Updated Successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("cart Update Failed");
			System.out.println(e);

		}
	}

	@Override
	public void addToCart(int productid, int qty) {
		int total = 0;
		
		System.out.print(orderid + "=orderrrrrrrrrrrrrr");
		String insertcartquery = "INSERT INTO furniture.carts (orderid,custid,productid,qty,price) " + "VALUES("
				+ orderid + "," + currentcustid + "," + productid + "," + qty + ","
				+ "(SELECT productprice FROM furniture.product WHERE productid = " + productid + ")*" + qty + "); ";

//		INSERT INTO furniture.carts (orderid,custid,productid,qty,price) 
//		VALUES(productid , custid , orderid ,qty ,(SELECT productprice 
//		FROM furniture.product WHERE productid = productid *2 )); 
		
//		String sam = "INSERT INTO furniture.carts (orderid,custid,productid,qty,price)"
//				+ " VALUES("+ productid +" , "+currentcustid+" , "+orderid+" ,"+qty+"  (SELECT productprice "
//				+ "FROM furniture.product WHERE productid = "+productid+")*" + qty +");";
		
		String sumQuery = "select sum(price) from furniture.carts where orderid=" + orderid + ";";
		System.out.println(sumQuery);

		System.out.println(insertcartquery);
		Statement stmt;
		try {
			System.out.println("Inside update order");
			stmt = connection.createStatement();
			System.out.println("Inside add to cart exceute query");
			stmt.executeUpdate(insertcartquery);
			System.out.println("Inside updateeeeeeeeeeeeeeeeeeee order");

			ResultSet rs = stmt.executeQuery(sumQuery);

			while (rs.next()) {
				total = rs.getInt(1);
				System.out.println(rs.getInt(1));

			}

			String sumInOrder = "UPDATE furniture.order SET total = " + total + " WHERE orderid=" + orderid + ";";
			stmt.executeUpdate(sumInOrder);
			System.out.println("add to cart Successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	public void sumproducts() {
		int total = 0;
		String sumQuery = "select sum(price) from furniture.carts where orderid=" + orderid + ";";
		System.out.println(sumQuery);
		
		System.out.println("Inside updateeeeeeeeeeeeeeeeeeee order");
		Statement stmt;
		ResultSet rs;
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sumQuery);
			while (rs.next()) {
				total = rs.getInt(1);
				System.out.println(rs.getInt(1));
				System.out.println(total);
				
				String sumInOrder = "UPDATE furniture.order SET total = " + total + " WHERE orderid=" + orderid + ";";
				stmt.executeUpdate(sumInOrder);

			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	

	@Override
	public void createOrder(int custid) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDateTime now = LocalDateTime.now();
		String orderdate = dtf.format(now);
		System.out.print("Inside create order function");
		// if (orderinit == false) {
		System.out.println("Inside create order if ");
		String getorderidquery = "SELECT MAX(orderid) FROM furniture.ORDER;";
		int id = 0;

		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(getorderidquery);
			System.out.println("Try block working");

			while (rs.next()) {
				id = rs.getInt(1);
				System.out.println(rs.getInt(1));
			}
			++id;
			System.out.println(id);
		} catch (SQLException e) {
			System.out.println(e);
		}

		int total = 0;
		String insertorderQuery = "INSERT INTO furniture.ORDER (orderid,orderdate,customerid,total) " + "VALUES (" + id
				+ ",'" + orderdate + "'," + custid + "," + total + ");";

		System.out.println(insertorderQuery);
		Statement stmt;
		try {
			stmt = connection.createStatement();
			stmt.executeUpdate(insertorderQuery);
		} catch (SQLException e) {
			System.out.println(e);
		}

		orderid = id;
		this.currentcustid = custid;
		orderinit = true;

//		} else {
//			System.out.println("Order not initialized");
//		}
		
	}

	@Override
	public List<CartDetails> getCartDetails() {
		list1.clear();

		String getcart = "SELECT product.productid,product.productimage,product.productname,product.productprice,carts.qty,carts.price from product,carts WHERE product.productid = carts.productid and orderid = "
				+ orderid + ";";
		System.out.println("This is a order id " + orderid);

		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(getcart);

			while (rs.next()) {
				CartDetails cartDetails = new CartDetails();

				cartDetails.setProductid(rs.getInt(1));
				cartDetails.setProductImage(rs.getString(2));
				cartDetails.setProductname(rs.getString(3));
				cartDetails.setProductprice(rs.getInt(4));
				cartDetails.setQty(rs.getInt(5));
				cartDetails.setPrice(rs.getInt(6));
				// cartDetails.setTotal(rs.getInt(6));
				System.out.println(cartDetails);
				list1.add(cartDetails);

			}

		} catch (SQLException e) {
			System.out.println(e);
		}
		return list1;
	}

	@Override
	public List<OrderDetails> gettotal() {
		list2.clear();
		System.out.println(orderid + "This is total function");
		String gettotal = "SELECT DISTINCT(total) FROM furniture.order WHERE orderid =" + orderid + ";";

		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(gettotal);

			while (rs.next()) {
				OrderDetails orderDetails = new OrderDetails();

				orderDetails.setTotal(rs.getInt(1));
				System.out.println(orderDetails);
				list2.add(orderDetails);

			}

		} catch (SQLException e) {
			System.out.println(e);
		}
		return list2;
	}
	
	
	

	@Override
	public void deletecartproduct(int id) {
System.out.println("Inside deletecart product");
		 
		
		String query = "DELETE FROM furniture.carts WHERE productid = '" + id + "' and orderid=" + orderid + ";";

		try {
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.executeUpdate();
			System.out.println("product removed from cart   ");
			sumproducts();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("product removed FAILED");
		}
		
	}

	

	

	

	

}
