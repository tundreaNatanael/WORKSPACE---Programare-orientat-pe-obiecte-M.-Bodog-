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

	public static Song getById(int id) throws SQLException, ClassNotFoundException {
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
	
	public static ArrayList<Song> getAll () throws SQLException, ClassNotFoundException {
		Connection conn = DBHelper.getConnection();
		String query = "SELECT * FROM songs";
		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery(query);
		ArrayList<Song> songs = new ArrayList<Song>();
		while(rs.next()) {
			int id = rs.getInt("id");
			String title = rs.getString("title");
			String author = rs.getString("author");
			String linMusicSheet = rs.getString("link_music_sheet");
			String verses = rs.getString("verses");
			int nrVotes = rs.getInt("nr_votes");
			songs.add(new Song(id, title, author, linMusicSheet, verses, nrVotes));
		}
		DBHelper.closeConnection();
		return songs;
	}
	
	public static void updateSong(Song song) throws SQLException, ClassNotFoundException {
		Connection conn = DBHelper.getConnection();
		String query = "UPDATE `songs` SET `title`='?',`author`='?',`link_music_sheet`='?',`verses`='?',`nr_votes`='?' WHERE id='?'";
		PreparedStatement setSong = conn.prepareStatement(query);
		
		setSong.setString(1, song.getTitle());
		setSong.setString(2, song.getAuthor());
		setSong.setString(3, song.getLinkMusicSheet());
		setSong.setString(4, song.getVerses());
		setSong.setInt(5, song.getNrVotes());
		setSong.setInt(6, song.getId());
		
		
		ResultSet rs = setSong.executeQuery();
		DBHelper.closeConnection();
		
	}
	
	public static void create(Song song) throws SQLException, ClassNotFoundException {
		Connection conn = DBHelper.getConnection();
		String query = "INSERT INTO `songs`(`title`, `author`, `link_music_sheet`, `verses`, `nr_votes`) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement setSong = conn.prepareStatement(query);
		
		setSong.setString(1, song.getTitle());
		setSong.setString(2, song.getAuthor());
		setSong.setString(3, song.getLinkMusicSheet());
		setSong.setString(4, song.getVerses());
		setSong.setInt(5, song.getNrVotes());
		
		
		ResultSet rs = setSong.executeQuery();
		DBHelper.closeConnection();
		
	}

}
