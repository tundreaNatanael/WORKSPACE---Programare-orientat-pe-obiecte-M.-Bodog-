package ro.emanuel.songs.controller;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ro.emanuel.songs.dao.SongDAO;
import ro.emanuel.songs.pojo.Song;

@Controller
public class SongsController {

	@GetMapping("/song")
	public String singleSong(@RequestParam int id) throws SQLException {
		Song song = SongDAO.getById(id);
		return "song.jsp";
	}
}
