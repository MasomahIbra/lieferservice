package dao;

import java.util.ArrayList;

import model.Essen;

public class EssenDAO {
	
	
	public ArrayList<Essen> getAll() {
		
		ArrayList<Essen> essen=new ArrayList<>();
		essen.add(new Essen(null, null, null, null, 0));
		essen.add(new Essen(null, null, null, null, 0));
		return essen;				
	}
	
	
	public void save(Essen essen) {
		System.out.println("speichern in DAO:_ " + essen.getFood());
	}

}
