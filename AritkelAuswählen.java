public class AritkelAuswählen {

	extends LieferantenDatenbank.sql

	public Kunde(LieferantenDatenbank.sql)
	{ Statement stmt = null;
	ResultSet result = null;

	try {
		stmt = connection.createStatement();
		result = stmt.executeQuery("SELECT * FROM LieferantenDatenbank.sql");
		result.first(); 


	}
