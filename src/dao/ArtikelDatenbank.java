package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ArtikelDatenbank {

	public static void main(String[] args) {


		try {
			// Datenbankklasse dynamisch erzeugen.
			Class.forName ("org.sqlite.JDBC");

			// Verbindung initialisieren.
			String datei = "Lieferanten.db3";
			String url = "jdbc:sqlite:" + datei;
			Connection conn =  DriverManager.getConnection (url);

			// Erzeugen einer SQL-Anweisung.
			String sql = "SELECT * from Essen";
			PreparedStatement statement = conn.prepareStatement (sql);


			// SQL-Anweisung ausführen.
			ResultSet resultSet = statement.executeQuery();
			
			//  Daten auslesen Datensatzzeiger auf den ersten Datensatz setzen.
			while(resultSet.next()) { 
				// Daten auslesen.
				String text = resultSet.getString("name");
			System.out.println(text);
		}

	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	}
}