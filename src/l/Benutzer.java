package l;

import java.sql.ResultSet;
import java.sql.SQLException;


public class Benutzer {
	int 	id;
	String	name,
			password,
			programmAdministrator,
			restaurantAdministrator,
			bestellungsBearbeiter,
			abrechner;
	static Benutzer angemeldeterBenutzer=null;
	
	// Das ist der Name der Tabelle für die Benutzer in der Datenbank
	private static final String TABLE_NAME = "Benutzer";
	
	// Das sind die Name der Spalten in der Datenbank"
	private static final String NAME_NAME = "Name";
	private static final String NAME_PASSWORT = "Passwort";
	private static final String NAME_PA = "ProgrammAdministrator";
	private static final String NAME_RA = "RestaurantAdministrator";
	private static final String NAME_BB = "BestellungsBearbeiter";
	private static final String NAME_ABRECHNER = "Abrechner";
	

	
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
		this.name = name;
	}



	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}



	/**
	 * @param programmAdministrator the programmAdministrator to set
	 */
	public void setProgrammAdministrator(String programmAdministrator) {
		this.programmAdministrator = programmAdministrator;
	}



	/**
	 * @param restaurantAdministrator the restaurantAdministrator to set
	 */
	public void setRestaurantAdministrator(String restaurantAdministrator) {
		this.restaurantAdministrator = restaurantAdministrator;
	}



	/**
	 * @param bestellungsBearbeiter the bestellungsBearbeiter to set
	 */
	public void setBestellungsBearbeiter(String bestellungsBearbeiter) {
		this.bestellungsBearbeiter = bestellungsBearbeiter;
	}



	/**
	 * @param abrechner the abrechner to set
	 */
	public void setAbrechner(String abrechner) {
		this.abrechner = abrechner;
	}



	/**
	 * @return the angemeldeterBenutzer
	 */
	public static Benutzer getAngemeldeterBenutzer() {
		return angemeldeterBenutzer;
	}



	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}



	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}



	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}



	/**
	 * @return the programmAdministrator
	 */
	public boolean getProgrammAdministrator() {
		return programmAdministrator.equals("J");
	}



	/**
	 * @return the restaurantAdministrator
	 */
	public boolean getRestaurantAdministrator() {
		return restaurantAdministrator.equals("J");
	}



	/**
	 * @return the bestellungsBearbeiter
	 */
	public boolean getBestellungsBearbeiter() {
		return bestellungsBearbeiter.equals("J");
	}



	/**
	 * @return the abrechner
	 */
	public boolean getAbrechner() {
		return abrechner.equals("J");
	}
	
	/**
	 * Diese Methode prüft, ob der angegebene Benutzer in der Datenbank
	 * mit dem angegebenen Passwort existiert. Falls die Angaben richtig sind,
	 * wird der Benutzer angemeldet.
	 * 
	 * @param name	Name des Benutzers
	 * @param password	Passwort des Benutzers
	 * @return true, wenn die Anmeldung erfolgreich war oder false, falls die 
	 * 			Anmeldung nicht erfolgreich war.
	 */
	
	public static boolean benutzerAnmelden(String name, String password) {
		try {
			String sql, pw;
			ResultSet rs;
			
			// Datenbankeintrag des Benutzers erfragen
			sql ="SELECT * FROM " + TABLE_NAME + " WHERE " + NAME_NAME + "=\"" + name + "\"";
			rs = Datenbank.abfragen(sql);
			
			// Falls der Benutzername nicht in der Datenbank gefunden wurde,
			// scheitert die Anmeldung
			if (rs.isAfterLast()) {
				return false;
			}
			
			// Passwort überprüfen
			pw = rs.getString("Passwort");
			if (pw.equals(password)) {
				
				// Wenn das Passwort ok ist, dann melden wir den Benutzer an
				angemeldeterBenutzer = new Benutzer();
				angemeldeterBenutzer.name = name;
				angemeldeterBenutzer.password= password;
				angemeldeterBenutzer.programmAdministrator = rs.getString(NAME_PA);
				angemeldeterBenutzer.restaurantAdministrator=rs.getString(NAME_RA);
				angemeldeterBenutzer.bestellungsBearbeiter= rs.getString(NAME_BB);
				angemeldeterBenutzer.abrechner=rs.getString(NAME_ABRECHNER);
				return true;
			} else {
				return false;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
			return false;
		}
	}
	
public static void main (String[] args) {
	if (benutzerAnmelden("Administrator2", "Admin01")) {
		System.out.println("Hurra");
	} else {
		System.out.println("So ein Frust");
	}
		
}





}
