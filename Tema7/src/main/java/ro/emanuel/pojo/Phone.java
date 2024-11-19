package ro.emanuel.pojo;

public class Phone {

	private int id;
	private String name;
	
	public Phone() {
		// TODO Auto-generated constructor stub
	}
	
	public Phone(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Phone(String name) {
		super();
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
