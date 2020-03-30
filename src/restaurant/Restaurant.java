package restaurant;

import java.awt.Image;

public class Restaurant {
	int id;
	int telefon;
	String name;
	String restaurantkategorie, adresse, email;
	Image bildDesRestaurants;

	// Das ist der Name der Tabelle für die Benutzer in der Datenbank
	private static final String TABLE_NAME = "Restaurant";

	/**
	 * Illegale ID, für Datensätze, die noch nicht in der Datenbank gespeichert sind 
	 * 
	 */
	public static final int ILLEGAL_ID = -1;

	// Das sind die Name der Spalten in der Datenbank"
	private static final String NAME_ID = "ID";
	private static final String NAME_NAME = "Name";
	private static final String NAME_Rk = "Restaurantkategorie";
	private static final String NAME_Adresse = "Adresse";
	private static final String NAME_Telefon = "Telefon";
	private static final String NAME_Email = "Email";
	private static final String NAME_BDR = "BildDesRestaurants";

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the telefon
	 */
	public int getTelefon() {
		return telefon;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the restaurantkategorie
	 */
	public String getRestaurantkategorie() {
		return restaurantkategorie;
	}

	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return the bildDesRestaurants
	 */
	public Image getBildDesRestaurants() {
		return bildDesRestaurants;

	}

}
