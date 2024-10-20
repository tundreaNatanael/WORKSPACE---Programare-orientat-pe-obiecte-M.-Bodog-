package ro.emanuel.drinks.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ro.emanuel.DBHelper;
import ro.emanuel.pojo.Drink;

public class DrinksDAO {
	public static Drink getById(int id) throws SQLException {
		Connection conn = DBHelper.getConnection();
		String query = "SELECT * FROM drinks where id=?";
		PreparedStatement getDrink = conn.prepareStatement(query);
		getDrink.setInt(1, id);
		
		ResultSet rs = getDrink.executeQuery();
		Drink drink = null;
		if(rs.next())
			drink = new Drink(rs.getInt("id"), rs.getString("flavour"), rs.getInt("price"), rs.getString("manufacturer"));
		DBHelper.closeConnection();
		if(drink != null)
			return drink;
		return null;
	}
	
	public static ArrayList<Drink> getAll() throws SQLException {
		Connection conn = DBHelper.getConnection();
		String query = "SELECT * FROM drinks";
		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery(query);
		ArrayList<Drink> drinks = new ArrayList<Drink>();
		while(rs.next()) {
			int id = rs.getInt("id");
			String flavour = rs.getString("flavour");
			int price = rs.getInt("price");
			String manufacturer = rs.getString("manufacturer");
			drinks.add(new Drink(id, flavour, price, manufacturer));
		}
		DBHelper.closeConnection();
		return drinks;
	}
	
	public static boolean create (Drink drink) throws SQLException {
		Connection conn = DBHelper.getConnection();
		
		String query = "INSERT INTO `drinks`(`flavour`, `price`, `manufacturer`) VALUES (?,?,?)";
		PreparedStatement createDrink = conn.prepareStatement(query);
		
		createDrink.setString(1, drink.getFlavour());
		createDrink.setInt(2, drink.getPrice());
		createDrink.setString(3, drink.getManufacturer());
		boolean response = createDrink.executeUpdate() > 0;
		DBHelper.closeConnection();
		return response;
	}
	
	public static boolean delete(int id) throws SQLException {
		Connection conn = DBHelper.getConnection();
		
		String query = "DELETE FROM `drinks` WHERE id=?";
		PreparedStatement deleteDrink = conn.prepareStatement(query);
		
		deleteDrink.setInt(1, id);
		
		boolean response = deleteDrink.executeUpdate() > 0;
		DBHelper.closeConnection();
		return response;
	}
	
	public static boolean update(Drink drink) throws SQLException {
		Connection conn = DBHelper.getConnection();
		
		String query = "UPDATE `drinks` SET `flavour`=?,`price`=?,`manufacturer`=? WHERE id=?";
		PreparedStatement updateDrink = conn.prepareStatement(query);
		
		updateDrink.setString(1, drink.getFlavour());
		updateDrink.setInt(2, drink.getPrice());
		updateDrink.setString(3, drink.getManufacturer());
		updateDrink.setInt(4, drink.getId());
		
		boolean response = updateDrink.executeUpdate() > 0;
		DBHelper.closeConnection();
		return response;
	}
}
