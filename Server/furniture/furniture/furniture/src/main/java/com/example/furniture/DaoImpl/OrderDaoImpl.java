package com.example.furniture.DaoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.furniture.Dao.OrderDao;
import com.example.furniture.DbUtil.DBUtil;
import com.example.furniture.Model.Order;



@Repository
public class OrderDaoImpl implements OrderDao {
	@Autowired
	static List<Order> orderlist = new ArrayList();
	Connection connection;
	Order currentOrder = new Order();

	public OrderDaoImpl() {
		connection = DBUtil.getConnection();
		System.out.println("Connection ---" + connection);
	}

	@Override
	public List<Order> ViewAllOrders() {

		System.out.println("Inside viewAll order");
		try {
			PreparedStatement stmt = connection.prepareStatement("select * from electronic.order");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Order order = new Order();
				System.out.println("Inside while");
				order.setOrderID(rs.getInt(1));
				order.setOrderDate(rs.getString(2));
				order.setCustomerID(rs.getInt(3));
				order.setTotal(rs.getInt(4));

				System.out.println("Inside while-2");
				orderlist.add(order);
				System.out.println(orderlist);
			}
		} catch (Exception e) {
			System.out.print(e);
		}
		return orderlist;
	}

	@Override
	public void addOrder(Order order) {
		System.out.println("Inside addOrder");
		int customerid = order.getCustomerID();
		int total = order.getTotal();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDateTime now = LocalDateTime.now();
		String orderdate = dtf.format(now);
		System.out.println("cust id"+customerid);
		System.out.println("orderdate"+orderdate);
		System.out.println("total"+total);

		try {
            String sql = "INSERT INTO electronic.order(orderdate,customerid,total) VALUES ('"+orderdate+"','"+customerid+"','"+total+"')";
            PreparedStatement stmt = connection.prepareStatement(sql); 
            stmt.executeUpdate();
            System.out.print("Order added");

		} catch (SQLException e) {
			System.out.println(e);
		}

	}

	@Override
	public void deleteOrder(int id) {
		System.out.println("Inside deleteOrder");
		String query = "DELETE FROM ORDER WHERE orderid ='" + id + "';";

		try {
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.executeUpdate();
			System.out.println("Order Deleted Successfully");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Order Delete FAILED");
		}

	}

	@Override
	public void updateOrder(Order order) {
		System.out.println("Inside updateProduct");
		int orderid = order.getOrderID();
		String orderdate = order.getOrderDate();

		String UpdateQuery = "UPDATE  ORDER SET orderdate='" + orderdate + "' WHERE orderid='" + orderid + "';";

		try {
			PreparedStatement stmt = connection.prepareStatement(UpdateQuery);
			stmt.executeUpdate();
			System.out.println("Order Updated Successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Order Update Failed");
			System.out.println(e);

		}

	}

}
