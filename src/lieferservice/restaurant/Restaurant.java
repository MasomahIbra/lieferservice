package lieferservice.restaurant;

import java.awt.Container;
import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;

import lieferservice.Datenbank;

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

	// SQL-Anweisung zum Einlesen aller Restaurants
	private static final String  SQL_ALLE_RESTAURANTS_EINLESEN =
			"SELECT * FROM Restaurant ORDER BY Name COLLATE NOCASE ASC";
	private static final String NAME_RESTAURANTKATEGORIE = null;
	private static final String NAME_ADRESSE = null;
	private static final String NAME_TELEFON = null;
	private static final String NAME_EMAIL = null;
	private static final String NAME_BILDRESTAURANTS = null;
	
	public Restaurant(boolean b) {
		// TODO Auto-generated constructor stub
	}


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

	/**
	 * Alle Restaurants aus der Datenbank in einer Liste speichern 
	 *@return die Liste mit der Restaurants
	 */
	public static Vector<Restaurant> alleRestaurants () {
		try {
			Vector<Restaurant> res = new Vector <Restaurant>();
			ResultSet rs;
			rs=Datenbank.abfragen(SQL_ALLE_RESTAURANTS_EINLESEN);


			while (rs.next()) {
				Restaurant r = new Restaurant (false);
				r.id = rs.getInt(NAME_ID);
				r.name = rs.getString(NAME_NAME);
				r.restaurantkategorie = rs.getString(NAME_RESTAURANTKATEGORIE);
				r.adresse = rs.getString(NAME_ADRESSE);
				r.telefon = rs.getInt(NAME_TELEFON);
				r.email = rs.getString(NAME_EMAIL);
				//r.bildDesRestaurants = rs.getImage(NAME_BILDRESTAURANTS);
				res.add(r);

			}
			return res;
		}
		catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
			System.exit(1);
			return null;


		}

	}


}

