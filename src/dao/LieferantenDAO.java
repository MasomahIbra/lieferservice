
package dao;

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

}
