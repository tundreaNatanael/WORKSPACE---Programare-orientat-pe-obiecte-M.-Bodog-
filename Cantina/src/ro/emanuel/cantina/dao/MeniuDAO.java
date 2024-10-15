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
	public static Meniu getMeniuById(int id) throws SQLException {
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
	
	public static ArrayList<Meniu> getAllMeniu() throws SQLException {
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
}
