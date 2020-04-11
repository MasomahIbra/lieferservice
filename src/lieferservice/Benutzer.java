package lieferservice;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;

public class Benutzer {
	int 	id;
	String	name,
	password,
	programmAdministrator,
	restaurantAdministrator,
	bestellungsBearbeiter,
	abrechner;

	// Der Gastbenutzer hat die Rechte des Gastes. Diese Instanz darf nicht verändert werden
	private static Benutzer GASTBENUTZER = new Benutzer(true);

	static Benutzer angemeldeterBenutzer = GASTBENUTZER;

	// Das ist der Name der Tabelle für die Benutzer in der Datenbank
	private static final String TABLE_NAME = "Benutzer";
	
	/**
	 * Illegale ID, für IDs, die noch nicht in der Datenbank gespeichert sind und für den Gastbenutzer
	 */
	public static final int ILLEGAL_ID = -1;

	// Das sind die Name der Spalten in der Datenbank"
	private static final String NAME_ID = "ID";
	private static final String NAME_NAME = "Name";
	private static final String NAME_PASSWORT = "Passwort";
	private static final String NAME_PA = "ProgrammAdministrator";
	private static final String NAME_RA = "RestaurantAdministrator";
	private static final String NAME_BB = "BestellungsBearbeiter";
	private static final String NAME_ABRECHNER = "Abrechner";
	
	// Name für den Gastbenutzer
	private static final String GUEST_NAME = "Gast";
	
	// Legale Zeichen für den Benutzernamen
	private static final String LEGAL_NAME_CHARACTERS = "[a-zA-Z\\d- ß_äöüÄÖÜ]+";
	
	// Anleitung für den Benutzernamen
	public static final String ANLEITUNG_BENUTZERNAME = 
			"Der Benutzername darf folgende Zeichen enthalten: Buchstaben, Ziffern, Bindestrich, Unterstrich, Leerzeichen. " +
			"Leerzeichen am Anfang oder Ende werden aber ignoriert.";



	/**
	 * Konstruktor
	 * @param gastBenutzerAnlegen: true, falls der Gastbenutzer angelegt werden soll
	 */
	private Benutzer(boolean gastBenutzerAnlegen) {
		this.id = ILLEGAL_ID;
		this.password = "";
		this.programmAdministrator = "N";
		this.restaurantAdministrator="N";
		this.bestellungsBearbeiter="N";
		this.abrechner="N";
		
		if (gastBenutzerAnlegen) {
			this.name = GUEST_NAME;
		} else {
			this.name = "";
		}
	}


	/**
	 * Setzt den Namen des Benutzers. Falls die ID ungleich ILLEGAL_ID ist, dann wird der Datenbankeintrag aufdatiert.
	 * @param name the name to set
	 */
	public void setName(String name) throws IllegalStateException {
		if (this == GASTBENUTZER) {
			throw new IllegalStateException("Gastbenutzer darf nicht verändert werden");
		}
		this.name = name;
		
		if (id != ILLEGAL_ID) {
			String sql = "UPDATE " + TABLE_NAME + " SET " + NAME_NAME + " = \"" + this.name + "\" WHERE " + NAME_ID + " = " + this.id;
			System.out.println(sql);
			try {
				Datenbank.befehlAusfuehren(sql);
			}
			catch (SQLException e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
	}



	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) throws IllegalStateException {
		if (this == GASTBENUTZER) {
			throw new IllegalStateException("Gastbenutzer darf nicht verändert werden");
		}
		this.password = password;
		
		if (id != ILLEGAL_ID) {
			String sql = "UPDATE " + TABLE_NAME + " SET " + NAME_PASSWORT + " = \"" + this.password + "\" WHERE " + NAME_ID + " = " + this.id;
			System.out.println(sql);
			try {
				Datenbank.befehlAusfuehren(sql);
			}
			catch (SQLException e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
	}



	/**
	 * @param programmAdministrator the programmAdministrator to set
	 */
	private void setProgrammAdministrator(String programmAdministrator) throws IllegalStateException {
		if (this == GASTBENUTZER) {
			throw new IllegalStateException("Gastbenutzer darf nicht verändert werden");
		}
		this.programmAdministrator = programmAdministrator;
		
		if (id != ILLEGAL_ID) {
			String sql = "UPDATE " + TABLE_NAME + " SET " + NAME_PA + " = \"" + this.programmAdministrator + "\" WHERE " + NAME_ID + " = " + this.id;
			System.out.println(sql);
			try {
				Datenbank.befehlAusfuehren(sql);
			}
			catch (SQLException e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
	}
	
	
	/**
	 * Bestimmt, ob der Benutzer ein Programmadministrator ist
	 * @param newValue true, falls der Benutzer ein Programmadministrator sein soll
	 */
	public void setProgrammAdministrator(Boolean newValue) {
		setProgrammAdministrator((newValue.booleanValue()) ? "J" : "N");
	}



	/**
	 * @param restaurantAdministrator the restaurantAdministrator to set
	 */
	private void setRestaurantAdministrator(String restaurantAdministrator) throws IllegalStateException {
		if (this == GASTBENUTZER) {
			throw new IllegalStateException("Gastbenutzer darf nicht verändert werden");
		}
		this.restaurantAdministrator = restaurantAdministrator;
		
		if (id != ILLEGAL_ID) {
			String sql = "UPDATE " + TABLE_NAME + " SET " + NAME_RA + " = \"" + this.restaurantAdministrator + "\" WHERE " + NAME_ID + " = " + this.id;
			System.out.println(sql);
			try {
				Datenbank.befehlAusfuehren(sql);
			}
			catch (SQLException e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
	}
	
	/**
	 * Bestimmt, ob der Benutzer ein Restaurantadministrator sein soll
	 * @param true, falls der Benutzer ein Restaurantadministrator sein soll
	 */
	public void setRestaurantAdministrator(Boolean newValue) {
		setRestaurantAdministrator((newValue.booleanValue()) ? "J" : "N");
	}


	/**
	 * @param bestellungsBearbeiter the bestellungsBearbeiter to set
	 */
	private void setBestellungsBearbeiter(String bestellungsBearbeiter) throws IllegalStateException {
		if (this == GASTBENUTZER) {
			throw new IllegalStateException("Gastbenutzer darf nicht verändert werden");
		}
		this.bestellungsBearbeiter = bestellungsBearbeiter;
		
		if (id != ILLEGAL_ID) {
			String sql = "UPDATE " + TABLE_NAME + " SET " + NAME_BB + " = \"" + this.bestellungsBearbeiter + "\" WHERE " + NAME_ID + " = " + this.id;
			System.out.println(sql);
			try {
				Datenbank.befehlAusfuehren(sql);
			}
			catch (SQLException e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
	}
	
	
	/**
	 * Bestimmt, ob der Benutzer ein Bestellungsbearbeiter sein soll
	 * @param true, falls der Benutzer ein Bestellungsbearbeiter sein soll
	 */
	public void setBestellungsBearbeiter(Boolean newValue) {
		setBestellungsBearbeiter((newValue.booleanValue()) ? "J" : "N");
	}



	/**
	 * @param abrechner the abrechner to set
	 */
	private void setAbrechner(String abrechner) throws IllegalStateException {
		if (this == GASTBENUTZER) {
			throw new IllegalStateException("Gastbenutzer darf nicht verändert werden");
		}
		this.abrechner = abrechner;
		
		if (id != ILLEGAL_ID) {
			String sql = "UPDATE " + TABLE_NAME + " SET " + NAME_ABRECHNER + " = \"" + this.abrechner + "\" WHERE " + NAME_ID + " = " + this.id;
			System.out.println(sql);
			try {
				Datenbank.befehlAusfuehren(sql);
			}
			catch (SQLException e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
	}

	
	/**
	 * Bestimmt, ob der Benutzer ein Abrechner ist
	 */
	public void setAbrechner(Boolean newValue) {
		setAbrechner((newValue.booleanValue()) ? "J" : "N");
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
	public boolean isProgrammAdministrator() {
		return programmAdministrator.equals("J");
	}



	/**
	 * @return the restaurantAdministrator
	 */
	public boolean isRestaurantAdministrator() {
		return restaurantAdministrator.equals("J");
	}



	/**
	 * @return the bestellungsBearbeiter
	 */
	public boolean isBestellungsBearbeiter() {
		return bestellungsBearbeiter.equals("J");
	}

	
	/**
	 * löscht den Benutzer aus der Datenbank
	 */
	public void ausDatenbankLoeschen() {
		try {
			String sql = "DELETE FROM " + TABLE_NAME + " WHERE " + NAME_ID + " = " + this.id;
			Datenbank.befehlAusfuehren(sql);
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}


	/**
	 * @return the abrechner
	 */
	public boolean isAbrechner() {
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
			pw = rs.getString(NAME_PASSWORT);
			if (pw.equals(password)) {

				// Wenn das Passwort ok ist, dann melden wir den Benutzer an
				angemeldeterBenutzer.id = rs.getInt(NAME_ID);
				angemeldeterBenutzer = new Benutzer(false);
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


	/**
	 * Diese Methode ermittelt, ob der Gastbenutzer angemeldet ist
	 */
	public static boolean isGastbenutzerAngemeldet() {
		return angemeldeterBenutzer == GASTBENUTZER;
	}
	
	
	/**
	 * Benutzer abmelden
	 */
	public static void abmelden() {
		angemeldeterBenutzer = GASTBENUTZER;
	}

	
	/**
	 * Liefert einen Vector mit allen Benutzern. Diese Methode wird die Benutzerverwaltung benötigt.
	 */
	public static Vector<Benutzer> alleBenutzer() {
		try {
			Vector<Benutzer> res = new Vector<Benutzer>();
			String sql;
			ResultSet rs;
	
			// Datenbankeintrag des Benutzers erfragen
			sql ="SELECT * FROM " + TABLE_NAME + " ORDER BY " + NAME_NAME + " COLLATE NOCASE ASC";
			rs = Datenbank.abfragen(sql);
			
			while (rs.next()) {
				Benutzer b = new Benutzer(false);
				b.id = rs.getInt(NAME_ID);
				b.name = rs.getString(NAME_NAME);
				b.password = rs.getString(NAME_PASSWORT);
				b.programmAdministrator = rs.getString(NAME_PA);
				b.restaurantAdministrator = rs.getString(NAME_RA);
				b.bestellungsBearbeiter = rs.getString(NAME_BB);
				b.abrechner = rs.getString(NAME_ABRECHNER);
				res.add(b);
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
	 * prüft, ob der übergebene String den Regeln für einen Benutzernamen entspricht
	 * @param name zu prüfender Name
	 * @return true, falls der Name ein gültiger Benutzername ist.
	 */
	public static boolean isGueltigerBenutzername(String name) {
		String s = name;
		s.trim();
		
		if (s.isEmpty()) {
			return false;
		}
		return s.matches(LEGAL_NAME_CHARACTERS);
	}
	
	
	/**
	 * prüft, ob der übergebene Benutzername bereits vergeben wurde.
	 * Die Prüfung unterscheidet nicht Groß-/Kleinschreibung
	 * @param name zu prüfender Benutzername
	 * @return ID des Datenbankeintrags mit dem angegebenen Benutzernamen oder ILLEGAL_ID, falls kein
	 * Datenbankeintrag mit dem angegebenen Namen existiert.
	 */
	public static int idDesBenutzernamens(String name) {
		Vector<Benutzer> liste = alleBenutzer();
		name = name.trim();
		
		for (int i = 0; i < liste.size(); i++) {
			if (name.equalsIgnoreCase(liste.elementAt(i).getName())) {
				return liste.elementAt(i).getId();
			}
		}
		return ILLEGAL_ID;
	}
	
	
	/**
	 * erzeugt einen neuen Benutzer in der Datenbank mit dem angegebenen Namen und dem angegebenen Passwort.
	 * Der Benutzer erhält keine Rechte.
	 * 
	 * @param name Benutzername
	 * @param passwort Passwort des Benutzers
	 * @throws IllegalArgumentException Der Benutzername ist vergeben oder nicht gültig
	 */
	public static void benutzerAnlegen(String name, String passwort) throws IllegalArgumentException {
		
		String benutzerName;
		String sql;
		
		benutzerName = name.trim();
		
		// Prüfen, ob der Benutzername ungültig oder bereits vorhanden ist
		if ((!isGueltigerBenutzername(benutzerName)) || (idDesBenutzernamens(benutzerName) != ILLEGAL_ID)) {
			throw new IllegalArgumentException();
		}
		
		// SQL Anweisung ausführen
		sql = "INSERT INTO " + TABLE_NAME + " (" +
				NAME_NAME + ", " + NAME_PASSWORT + ", " + NAME_PA + ", " + NAME_RA + ", " + NAME_BB + ", " + NAME_ABRECHNER + 
				") VALUES ('" +
				benutzerName + "', '" +
				passwort + "', 'N', 'N', 'N', 'N')";
		try {
			Datenbank.befehlAusfuehren(sql);
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.exit(1);
		}		
	}

}
