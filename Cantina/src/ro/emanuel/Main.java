package ro.emanuel;
import ro.emanuel.cantina.dao.MeniuDAO;
import ro.emanuel.pojo.Meniu;
public class Main {

	public static void main(String[] args) {
		try {
			MeniuDAO.createMenu(new Meniu(5, "ciorba burta", "chicken burger", "afine", 17));
			System.out.println(MeniuDAO.getAllMenus().toString());
		}
		catch (Exception e) {
			System.out.println(e);
		}

	}

}
