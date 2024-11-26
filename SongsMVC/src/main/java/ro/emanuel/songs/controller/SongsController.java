package ro.emanuel.songs.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@GetMapping("/song/edit/{id}")
	public String editSong (Model model, @PathVariable int id) throws ClassNotFoundException, SQLException {
		Song song = SongDAO.getById(id);
		
		model.addAttribute("song", song);
		
		return "/songEdit.jsp";
	}
	
	@PostMapping("/song/edit/")
	public String saveEditSong (@ModelAttribute("song") Song song, Model map, BindingResult result) throws ClassNotFoundException, SQLException {
		
		SongDAO.updateSong(song);
		
		return "redirect:/songs";
	}
	
	@GetMapping("/songs/createSong")
	public String createSong (Model model) throws ClassNotFoundException, SQLException {
		
		Song song = new Song();
		model.addAttribute("newSong", song);
		
		return "/createSong.jsp";
	}
	
	@PostMapping("/songs/saveNewSong")
	public String saveNewSong (@ModelAttribute("song") Song song, Model map, BindingResult result) throws ClassNotFoundException, SQLException {
		
		SongDAO.create(song);
		
		return "redirect:/songs";
	}
}
