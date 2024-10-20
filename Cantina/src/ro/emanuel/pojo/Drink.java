package ro.emanuel.pojo;

public class Drink {

	private int id;
	private String flavour;
	private int price;
	private String manufacturer;
	
	public Drink(int id, String flavour, int price, String manufacturer) {
		this.id = id;
		this.flavour = flavour;
		this.price = price;
		this.manufacturer = manufacturer;
	}

	public int getId() {
		return id;
	}

	public String getFlavour() {
		return flavour;
	}

	public int getPrice() {
		return price;
	}

	public String getManufacturer() {
		return manufacturer;
	}

}
