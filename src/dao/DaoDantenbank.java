
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoDantenbank {

	static Connection conn = null;
	
	
	/**
	 * Diese Methode öffnet die Datenbank.
	 * Wenn ein Fehler auftritt, wird das Programm beendet.
	 */
	private static void oeffneDatenbank() {
		try {
			// Datenbankklasse dynamisch erzeugen.
			Class.forName ("sqlite-jdbc-3.7.2.jar");

			// Verbindung initialisieren.
			String datei = "Lieferanten.sql";
			String url = "sqlite-jdbc-3.7.2.jar:" + datei;
			conn =  DriverManager.getConnection (url);
		}
		catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	
	/**
	 * Diese Methode führt eine Datenbankabfrage durch.
	 * 
	 * @param sql SQL-Anweisung mit der Datenbankabfrage
	 * @throws SQLException, falls ein Fehler auftritt
	 */
	public static ResultSet abfragen(String sql) throws SQLException{
		// Falls das noch nicht passiert ist, öffnen wir die Datenbank
		if (conn==null) oeffneDatenbank();
		
		// SQL Abfrage durchführen
		PreparedStatement statement = conn.prepareStatement (sql);
		ResultSet resultSet = statement.executeQuery();	
		
		return resultSet;
	}
	

}