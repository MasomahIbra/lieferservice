package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Lieferant;

public class LieferantenDAO {

	private String url;

	public LieferantenDAO() {

		try {
			Class.forName("org.sqlite.JDBC");
			String datei = "Lieferant.db";
			this.url = "jdbc:sqlite:" + datei;
			Connection conn = DriverManager.getConnection(url);


			String sql = "SELECT * from Lieferant";
			PreparedStatement statement = conn.prepareStatement(sql);


			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {		
			}
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public ArrayList<Lieferant> getAll() {

		ArrayList<Lieferant> liefer=new ArrayList<>();
		liefer.add(new Lieferant(1, "foo"));
		liefer.add(new Lieferant(2, "bar"));
		return liefer;


	}

	public ArrayList<Lieferant> getByName() {
		ArrayList<Lieferant> liefer=new ArrayList<>();
		liefer.add(new Lieferant(1, "foo"));
		liefer.add(new Lieferant(2, "bar"));
		return liefer;
	}

	public void save(Lieferant lieferant) {
		System.out.println("speichern in DAO:_ " + lieferant.getName());
	}

}
