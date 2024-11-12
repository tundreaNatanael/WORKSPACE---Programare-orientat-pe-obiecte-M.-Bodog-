package ro.emanuel.songs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ro.emanuel.songs.helper.DBHelper;
import ro.emanuel.songs.pojo.Song;

public class SongDAO {

	public static Song GetById(int id) throws SQLException {
		Connection conn = DBHelper.getConnection();
		String query = "SELECT * FROM songs where id=?";
		PreparedStatement getSong = conn.prepareStatement(query);
		getSong.setInt(1, id);
		
		ResultSet rs = getSong.executeQuery();
		Song song = null;
		if(rs.next())
			song = new Song(rs.getInt("id"), rs.getString("title"), rs.getString("author"), rs.getString("link_music_sheet"), rs.getString("verses"), rs.getInt("nr_votes"));
		DBHelper.closeConnection();
		if(song != null)
			return song;
		return null;
	}
	
	public static ArrayList<Song> getAll () throws SQLException {
		Connection conn = DBHelper.getConnection();
		String query = "SELECT * FROM songs";
		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery(query);
		ArrayList<Song> song = new ArrayList<Song>();
		while(rs.next()) {
			int id = rs.getInt("id");
			String title = rs.getString("title");
			String author = rs.getString("author");
			String linMusicSheet = rs.getString("link_music_sheet");
			String verses = rs.getString("verses");
			int nrVotes = rs.getInt("nr_votes");
			song.add(new Song(id, title, author, linMusicSheet, verses, nrVotes));
		}
		DBHelper.closeConnection();
		return song;
	}

}
