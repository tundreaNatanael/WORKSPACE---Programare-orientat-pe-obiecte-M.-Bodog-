package ro.emanuel.songs.pojo;

public class Song {

	private int id;
	private String title;
	private String author;
	private String linkMusicSheet;
	private String verses;
	private int nrVotes;
	
	public Song() {
		// TODO Auto-generated constructor stub
	}
	
	public Song(int id, String title, String author, String linkMusicSheet, String verses, int nrVotes) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.linkMusicSheet = linkMusicSheet;
		this.verses = verses;
		this.nrVotes = nrVotes;
	}
	
	public Song(String title, String author, String linkMusicSheet, String verses, int nrVotes) {
		super();
		this.title = title;
		this.author = author;
		this.linkMusicSheet = linkMusicSheet;
		this.verses = verses;
		this.nrVotes = nrVotes;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getLinkMusicSheet() {
		return linkMusicSheet;
	}

	public String getVerses() {
		return verses;
	}

	public int getNrVotes() {
		return nrVotes;
	}

}
