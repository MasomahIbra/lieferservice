package model;

public class Essen {
	
	private String Kategorie;
	private String Art;
	private String Food;
	private String Groesse;
	private int Preis;
	
	
	public Essen(String Kategorie, String Art, String Food, String Groesse, int Preis) {
		super();
		this.Kategorie = Kategorie;
		this.Art = Art;
		this.Food = Food;
		this.Groesse = Groesse;
		this.Preis = Preis;
	}

	public String getKategorie() {
		return Kategorie;
	}

	public String getArt() {
		return Art;
	}
	
	public String getFood() {
		return Food;
	}
	
	public String getGroesse() {
		return Groesse;
	}
	
	public int getPreis() {
		return Preis;
	}
}
