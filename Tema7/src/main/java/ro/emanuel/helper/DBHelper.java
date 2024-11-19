package ro.emanuel.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBHelper {

	private static Connection conn;
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(conn == null || conn.isClosed()) {
			Properties connectionProps = new Properties();
			connectionProps.put("user", "root");
			connectionProps.put("password", "");
			
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/tema7", 
					connectionProps);
		}
		return conn;
	}
	
	public static void closeConnection() throws SQLException {
		if(conn != null && !conn.isClosed())
			try {
				conn.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
	}

}
