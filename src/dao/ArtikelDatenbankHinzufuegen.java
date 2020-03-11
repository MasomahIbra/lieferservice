package dao;

import java.sql.ResultSet;
import java.sql.SQLException;


public class ArtikelDatenbankHinzufuegen {
	int 	id;
	String	name,
			Produktinfo,
			lieferanten_id,
			kategorie_id;
	static ArtikelDatenbankHinzufuegen artikelHinzufuegen=null;

	// Das ist der Name der Tabelle für die Benutzer in der Datenbank
	private static final String TABLE_NAME = "Essen";

	// Das sind die Name der Spalten in der Datenbank"
	private static final String NAME_NAME = "Name";
	private static final String ProduktInfo = "Produktinfo";
	private static final String lieferanten_Id = "lieferanten_id";
	private static final String kategorie_Id = "kategorie_id";




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
	public void setproduktInfo(String produktInfo) {
		this.Produktinfo = produktInfo;
	}



	/**
	 * @param programmAdministrator the programmAdministrator to set
	 */
	public void setlieferanten_id(String lieferanten_id) {
		this.lieferanten_id = lieferanten_id;
	}



	/**
	 * @param restaurantAdministrator the restaurantAdministrator to set
	 */
	public void sekategorie_id(String kategorie_id) {
		this.kategorie_id = kategorie_id;
	}




	/**
	 * @return the angemeldeterBenutzer
	 */
	public static ArtikelDatenbankHinzufuegen getartikelHinzufuegen() {
		return artikelHinzufuegen;
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
	 * @return the produktInfo
	 */
	public String getproduktInfo() {
		return Produktinfo;
	}
	/**
	 * @return the lieferanten_id
	 */
	public String gelieferanten_id() {
		return lieferanten_id;
	}

	/**
	 * @return the kategorie_id
	 */
	public String getkategorie_id() {
		return kategorie_id;
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
			rs = DaoDantenbank.abfragen(sql);

//			// Falls der Benutzername nicht in der Datenbank gefunden wurde,
//			// scheitert die Anmeldung
//			if (rs.isAfterLast()) {
//				return false;
//			}
			
//	public static void main (String[] args) {
//		if (artikelHinzufuegen("Pizza")) {
//			System.out.println("Hurra");
//		} else {
//			System.out.println("So ein Frust");
//		}
//
//	}


