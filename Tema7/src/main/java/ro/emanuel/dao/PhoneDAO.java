package ro.emanuel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ro.emanuel.helper.DBHelper;
import ro.emanuel.pojo.Phone;

public class PhoneDAO {

	public static Phone getById(int id) throws SQLException, ClassNotFoundException {
		Connection conn = DBHelper.getConnection();
		String query = "SELECT * FROM phone where id=?";
		PreparedStatement getPhone = conn.prepareStatement(query);
		getPhone.setInt(1, id);
		
		ResultSet rs = getPhone.executeQuery();
		Phone phone = null;
		if(rs.next())
			phone = new Phone(rs.getInt("id"), rs.getString("name"));
		DBHelper.closeConnection();
		if(phone != null)
			return phone;
		return null;
	}
	
	public static ArrayList<Phone> getAll () throws SQLException, ClassNotFoundException {
		Connection conn = DBHelper.getConnection();
		String query = "SELECT * FROM phone";
		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery(query);
		ArrayList<Phone> phones = new ArrayList<Phone>();
		while(rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			phones.add(new Phone(id, name));
		}
		DBHelper.closeConnection();
		return phones;
	}
}
