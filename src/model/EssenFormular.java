package model;

public class EssenFormular {

	private int id;
	private String kategorie;
	private String art;
	private String food;
	private String groesse;
	private int preis;
	
	
	public EssenFormular(int id, String kategorie,String art,String food,String groesse, int preis ) {
		super();
		this.id = id;
		this.kategorie = kategorie;
		this.art = art;
		this.food = food;
		this.groesse = groesse;
		this.preis = preis;
	}

	public int getId() {
		return id;
	}

	public String getKategorie() {
		return kategorie;
	}
	
	public String getart() {
		return art;
	}
	
	public String getfood() {
		return food;
	}
	
	public String getgroesse() {
		return groesse;
	}
	
	public int getpreis() {
		return preis;
	}
	

}

