package Admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class lieferantHinzufügen {

	public static void main(String[] args) {
	
		try {
			// Datenbankklasse dynamisch erzeugen.
			Class.forName ("org.sqlite.JDBC");

			// Verbindung initialisieren.
			String datei = "Lieferant.db";
			String url = "jdbc:sqlite:" + datei;
			Connection conn =  DriverManager.getConnection (url);

			// Erzeugen einer SQL-Anweisung.
			String sql = "SELECT * from Lieferant where Kategorie ";
			PreparedStatement statement = conn.prepareStatement (sql);
			

			// SQL-Anweisung ausführen.
			ResultSet resultSet = statement.executeQuery();
			
			//  Daten auslesen Datensatzzeiger auf den ersten Datensatz setzen.
			while(resultSet.next()) { 
				// Daten auslesen.
				String text = resultSet.getString("Kategorie");
				text  +=", " + resultSet.getString("Art");
				text +=", " + resultSet.getString("Food");
				text +=", " + resultSet.getString("Groesse");
				text +=", " + resultSet.getString("Preis");
				System.out.println(text);
				
			}
	} catch (ClassNotFoundException er) {
		er.printStackTrace();
	} catch (SQLException er) {
		// TODO Auto-generated catch block
		er.printStackTrace();
		}
	}
}

