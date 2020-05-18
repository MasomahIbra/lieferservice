package lieferservice.restaurant;

import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;

import lieferservice.Datenbank;

public class Restaurant {
	int id;
	String name;
	String restaurantkategorie; 
	String adresse; 
	String telefon; 
	String email;
	Image bildDesRestaurants;


	// Das ist der Name der Tabelle für die Benutzer in der Datenbank
	private static final String TABLE_NAME = "Restaurant";

	/**
	 * Illegale ID, für Datensätze, die noch nicht in der Datenbank gespeichert sind 
	 */
	public static final int ILLEGAL_ID = -1;

	// Das sind die Name der Spalten in der Datenbank"
	private static final String NAME_ID = "ID";
	private static final String NAME_NAME = "Name";
	private static final String NAME_RK = "Restaurantkategorie";
	private static final String NAME_ADRESSE = "Adresse";
	private static final String NAME_TELEFON = "Telefon";
	private static final String NAME_EMAIL = "E-Mail";
	private static final String NAME_BDR = "BildDesRestaurants";
	
	// Schablone für eine Update-Anweisung
	private static final String SQL_UPDATE = "UPDATE Restaurant SET Name = V1, Restaurantkategorie = V2, Adresse = V3, Telefon = V4, E-Mail = V5 WHERE ID = XXX"; 

	// SQL-Anweisung zum Einlesen aller Restaurants
	private static final String  SQL_ALLE_RESTAURANTS_EINLESEN =
			"SELECT * FROM Restaurant ORDER BY Name COLLATE NOCASE ASC";


	/**
	 * Dieser Konstruktor wird benutzt, um ein neues Restaurant zu erzeugen, das noch
	 * nicht in der Datenbank gespeichert ist.
	 */
  	public Restaurant() {
		this.id = ILLEGAL_ID;
		this.name = "";
		this.restaurantkategorie = "";
		this.adresse = "";
		this.telefon = "";
		this.email = "";
		this.bildDesRestaurants = null;
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
	public String getTelefon() {
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
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		String s = name.strip();
		if (!s.isEmpty())
			this.name = s;
	}


	/**
	 * @param restaurantkategorie the restaurantkategorie to set
	 */
	public void setRestaurantkategorie(String restaurantkategorie) {
		this.restaurantkategorie = restaurantkategorie.strip();
	}


	/**
	 * @param telefon the telefon to set
	 */
	public void setTelefon(String telefon) {
		this.telefon = telefon.strip();
	}


	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse.strip();
	}


	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email.strip();
	}


	/**
	 * @param bildDesRestaurants the bildDesRestaurants to set
	 */
	public void setBildDesRestaurants(Image bildDesRestaurants) {
		this.bildDesRestaurants = bildDesRestaurants;
	}

	
	/**
	 * Alle Restaurants aus der Datenbank in einer Liste speichern 
	 * @return die Liste mit den Restaurants
	 */
	public static Vector<Restaurant> alleRestaurants () {
		try {
			Vector<Restaurant> res = new Vector <Restaurant>();
			ResultSet rs;
			rs=Datenbank.abfragen(SQL_ALLE_RESTAURANTS_EINLESEN);

			while (rs.next()) {
				Restaurant r = new Restaurant();
				r.id = rs.getInt(NAME_ID);
				r.name = rs.getString(NAME_NAME);
				r.restaurantkategorie = rs.getString(NAME_RK);
				r.adresse = rs.getString(NAME_ADRESSE);
				r.telefon = rs.getString(NAME_TELEFON);
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

	
	/**
	 * Die Methode dient dazu, um dieses Restaurant in der Datenbank zu speichern
	 */
	public void inDerDatenbankSpeichern () {
		final String CMD_NEUER_DATENSATZ = "INSERT INTO " + TABLE_NAME + 
				" (" + NAME_NAME + ", " +
				NAME_RK + ", " +
				NAME_ADRESSE + ", " +
				NAME_TELEFON + ", " +
				NAME_EMAIL + ") VALUES (\"" +
				this.name + "\", \"" +
				this.restaurantkategorie + "\", \"" +
				this.adresse + "\", \"" +
				this.telefon + "\", \"" +
				this.email + "\");";
		
		String cmdUpdate = SQL_UPDATE;
		cmdUpdate.replace("V1", "\"" + this.name + "\"");
		cmdUpdate.replace("V2", "\"" + this.restaurantkategorie + "\"");
		cmdUpdate.replace("V3", "\"" + this.adresse + "\"");
		cmdUpdate.replace("V4", "\"" + this.telefon + "\"");
		cmdUpdate.replace("V5", "\"" + this.email + "\"");
		cmdUpdate.replace("XXX", "\"" + this.id + "\"");
	
		try {
//			int i = 0;
//			
//			if (i == 0) {
//				System.out.println("ist null");
//			} else {
//				System.out.println("ist nicht null");
//			}
//			
//			System.out.println((i == 0) ? "ist null" : "ist nicht null");
			
			Datenbank.befehlAusfuehren((this.id == ILLEGAL_ID) ? CMD_NEUER_DATENSATZ : cmdUpdate);
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	
	
	
	
	/**
	 * Diese Methode löscht das Restaurant aus der Datenbank
	 */
	public void ausDatenbankLoeschen() {
		try {
			if (this.id == ILLEGAL_ID) {
				throw new IllegalStateException("Ey, den Datensatz gibt's nicht! Manno");
			}
			String sql = "DELETE FROM " + TABLE_NAME + " WHERE " + NAME_ID + " = " + this.id;
			Datenbank.befehlAusfuehren(sql);
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.exit(1);

		}
	}
	
	
	/**
	 * Diese Methode prüft, ob das Restaurant gültige Daten hat. Falls nicht, 
	 * wird eine Fehlermeldung zurückgegeben.
	 * @return String mit der Fehlermeldung oder null, falls alles ok ist.
	 */
	public String pruefen() {
		// Namen prüfen: der Name darf nicht leer sein
		if (this.name.isEmpty())
			return "Der Name des Restaurants darf nicht leer sein.";
		
		// Kategorie prüfen: die Kategorie darf nicht leer sein
		if (this.restaurantkategorie.isEmpty())
			return "Die Restaurantkategorie darf nicht leer sein.";
		
		// Adresse prüfen: die Adresse darf nicht leer sein
		if (this.adresse.isEmpty())
			return "Die Adresse darf nicht leer sein";
		
		// E-Mail prüfen
		if (this.email.isEmpty())
			return "Die E-Mail darf nicht leer sein.";
		if (this.email.equalsIgnoreCase("masomah01@gmail.com"))
			return "nix da. Meine E-Mail nimmst Du nicht für Dein schäbiges Restaurant. Gruß, Masomah";
		
		// Bild des Restaurants prüfen: keine Prüfung
		
		return null; // alles ok
	}
	
}