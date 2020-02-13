package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Lieferant;

public class LieferantenDAO {
	
	
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

	public void löschen (Lieferant id) {
		System.out.println("Eintrag wurde gelöscht: ");
		  public void delete() throws DB_FehlerException {
		        int id = this.emailkontakt.getId();
		        Connection conn = null;
		        try {
		            conn = DriverManager.getConnection(url);
		            String sql = "DELETE FROM lieferant WHERE ID like ?";
		            PreparedStatement statement = conn.prepareStatement (sql);
		            statement.setInt(1,id);
		            statement.executeUpdate();
		        }
		        catch (SQLException e) {
		            e.printStackTrace();
		            throw new DB_FehlerException("Dieser Vorgang ist gescheitert");      
		        }
		    }
	}
	
	
	
	
	
	
}

