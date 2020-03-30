package lieferservice;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Datenbank {

	static Connection conn = null;
	
	
	/**
	 * Diese Methode öffnet die Datenbank.
	 * Wenn ein Fehler auftritt, wird das Programm beendet.
	 */
	private static void oeffneDatenbank() {
		try {
			// Datenbankklasse dynamisch erzeugen.
			Class.forName ("org.sqlite.JDBC");

			// Verbindung initialisieren.
			String datei = "pp.db";
			String url = "jdbc:sqlite:" + datei;
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
		System.out.println(sql);
		PreparedStatement statement = conn.prepareStatement (sql);
		ResultSet resultSet = statement.executeQuery();	
		
		return resultSet;
	}
	
	
	/**
	 * Diese Methode führt einen Datenbankbefehl aus.
	 * @throws SQLException, falls ein Fehler auftritt
	 */
	public static void befehlAusfuehren(String sql) throws SQLException {
		System.out.println(sql);
		
		// Falls das noch nicht passiert ist, öffnen wir die Datenbank
		if (conn==null) oeffneDatenbank();
		
		// SQL Abfrage durchführen
		PreparedStatement statement = conn.prepareStatement (sql);
		statement.execute();
	}
}
