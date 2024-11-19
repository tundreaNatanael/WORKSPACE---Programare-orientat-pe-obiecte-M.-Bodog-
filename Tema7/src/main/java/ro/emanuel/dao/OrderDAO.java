package ro.emanuel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ro.emanuel.helper.DBHelper;
import ro.emanuel.pojo.Order;

public class OrderDAO {

	public static Order getById(int id) throws SQLException, ClassNotFoundException {
		Connection conn = DBHelper.getConnection();
		String query = "SELECT * FROM product_order where id=?";
		PreparedStatement getOrder = conn.prepareStatement(query);
		getOrder.setInt(1, id);
		
		ResultSet rs = getOrder.executeQuery();
		Order order = null;
		if(rs.next())
			order = new Order(rs.getInt("id"), rs.getString("date"), rs.getInt("id_product"));
		DBHelper.closeConnection();
		if(order != null)
			return order;
		return null;
	}
	
	public static ArrayList<Order> getAll () throws SQLException, ClassNotFoundException {
		Connection conn = DBHelper.getConnection();
		String query = "SELECT * FROM product_order";
		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery(query);
		ArrayList<Order> orders = new ArrayList<Order>();
		while(rs.next()) {
			int id = rs.getInt("id");
			String date = rs.getString("date");
			int idProduct = rs.getInt("idProduct");
			
			orders.add(new Order(id, date, idProduct));
		}
		DBHelper.closeConnection();
		return orders;
	}
}
