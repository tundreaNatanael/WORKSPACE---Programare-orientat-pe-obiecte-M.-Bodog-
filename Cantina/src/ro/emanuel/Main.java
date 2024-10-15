package ro.emanuel;
import ro.emanuel.cantina.dao.*;
public class Main {

	public static void main(String[] args) {
		try {
			System.out.println(MeniuDAO.getMeniuById(1).toString());
		}
		catch (Exception e) {
			System.out.println(e);
		}

	}

}
