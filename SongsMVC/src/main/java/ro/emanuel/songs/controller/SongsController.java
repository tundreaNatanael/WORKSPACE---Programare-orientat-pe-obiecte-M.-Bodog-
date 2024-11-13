package ro.emanuel.songs.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ro.emanuel.songs.dao.SongDAO;
import ro.emanuel.songs.pojo.Song;

@Controller
public class SongsController {

	@GetMapping("/song")
	public String singleSong(@RequestParam int id, Model model) throws SQLException, ClassNotFoundException {
		Song song = SongDAO.getById(id);
		
		model.addAttribute("s", song);
		
		return "song.jsp";
	}
	
	@GetMapping("/songs")
	public String allSongs(Model model) throws SQLException, ClassNotFoundException {
		ArrayList<Song> allSongs = SongDAO.getAll();
		
		model.addAttribute("all", allSongs);
		
		return "songs.jsp";
	}
}
