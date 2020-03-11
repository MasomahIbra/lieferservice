
public class BestellungAnziegen {

	public static void main(String[] args)

	public class Kunde
	{
		private String name;
		private String vorname;
		private String strasse;
		private String plz;
		private String ort;

		Kunde (String n , String v , String s , String p , String o)
		{
			name = n;
			vorname = v;
			strasse = s;
			plz = p;
			ort = o;

		}

		public String get_name()
		{return name;    }

		public String get_vorname()
		{return vorname; }

		public String get_strasse()
		{return strasse;  }

		public String get_plz()
		{return plz;}

		public String get_ort()
		{return ort;   }

	}

	public class Gerichte
	{

		private double preis;
		private String bezeichnung;


		Produkt (double p, String bez)
		{

			preis = p;
			bezeichnung = bez;

		}


		public double get_preis()
		{return preis; }

		public String get_bezeichnung()
		{return bezeichnung; }

	}

	public void Rechnung()
	{
		System.out.println(get_preis() + " " + get_bezeichnung());
		System.out.println("Rechnung für die Bestellung " + preis + bezeichnung);
		System.out.print(get_vorname()+ " ");
		System.out.print(get_name());

	}
