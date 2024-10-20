package ro.emanuel.cantina.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ro.emanuel.DBHelper;
import ro.emanuel.pojo.Meniu;

public class MeniuDAO {
	public static Meniu getById(int id) throws SQLException {
		Connection conn = DBHelper.getConnection();
		String query = "SELECT * FROM cantina where id=?";
		PreparedStatement getMeniu = conn.prepareStatement(query);
		getMeniu.setInt(1, id);
		
		ResultSet rs = getMeniu.executeQuery();
		Meniu meniu = null;
		if(rs.next())
			meniu = new Meniu(rs.getInt("id"), rs.getString("fel1"), rs.getString("fel2"), rs.getString("desert"), rs.getInt("pret"));
		DBHelper.closeConnection();
		if(meniu != null)
			return meniu;
		return null;
	}
	
	public static ArrayList<Meniu> getAll() throws SQLException {
		Connection conn = DBHelper.getConnection();
		String query = "SELECT * FROM cantina";
		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery(query);
		ArrayList<Meniu> meniuri = new ArrayList<Meniu>();
		while(rs.next()) {
			int id = rs.getInt("id");
			String fel1 = rs.getString("fel1");
			String fel2 = rs.getString("fel2");
			String desert = rs.getString("desert");
			int pret = rs.getInt("pret");
			meniuri.add(new Meniu(id, fel1, fel2, desert, pret));
		}
		DBHelper.closeConnection();
		return meniuri;
	}
	
	public static boolean create (Meniu menu) throws SQLException {
		Connection conn = DBHelper.getConnection();
		
		String query = "INSERT INTO `cantina`(`fel1`, `fel2`, `desert`, `pret`) VALUES (?,?,?,?)";
		PreparedStatement createMenu = conn.prepareStatement(query);
		
		createMenu.setString(1, menu.getFel1());
		createMenu.setString(2, menu.getFel2());
		createMenu.setString(3, menu.getDesert());
		createMenu.setInt(4, menu.getPret());
		
		boolean response = createMenu.executeUpdate() > 0;
		DBHelper.closeConnection();
		return response;
	}
	
	public static boolean delete(int id) throws SQLException {
		Connection conn = DBHelper.getConnection();
		
		String query = "DELETE FROM `cantina` WHERE id=?";
		PreparedStatement deleteMenu = conn.prepareStatement(query);
		
		deleteMenu.setInt(1, id);
		
		boolean response = deleteMenu.executeUpdate() > 0;
		DBHelper.closeConnection();
		return response;
	}
	
	public static boolean update(Meniu menu) throws SQLException {
		Connection conn = DBHelper.getConnection();
		
		String query = "UPDATE `cantina` SET `fel1`=?,`fel2`=?,`desert`=?,`pret`=? WHERE id=?";
		PreparedStatement updateMenu = conn.prepareStatement(query);
		
		updateMenu.setString(1, menu.getFel1());
		updateMenu.setString(2, menu.getFel2());
		updateMenu.setString(3, menu.getDesert());
		updateMenu.setInt(4, menu.getPret());
		updateMenu.setInt(5, menu.getId());
		
		boolean response = updateMenu.executeUpdate() > 0;
		DBHelper.closeConnection();
		return response;
	}
}
