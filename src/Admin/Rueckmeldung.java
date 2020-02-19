package Admin;

public class Rueckmeldung {
	
	private String rueckmeldung;
	 private String loeschung;
	 private String loeschungErfolgreich;
	    private String loeschungHatNichtErfolgreich;

	    
	    public Rueckmeldung(String loeschungErfolgreich, String loeschungHatNichtErfolgreich)
	    {
	        rueckmeldung = loeschung;
	        this.loeschungErfolgreich = loeschungErfolgreich;
	        this.loeschungHatNichtErfolgreich = loeschungHatNichtErfolgreich;
	    }
	    /**
	     * @return Der Befehl wird nicht geloescht und Liefere 'null'
	     * 
	     */
	    public String loeschungHatNichtErfolgreich ()
	    {
	        return rueckmeldung;
	    }
	    
	    /**
	     *  @return 'true', wenn dieser Befehl nicht verstanden wurde.
	     */ 

	    public boolean loeschngIstUnbekannt()
	    {
	        return (rueckmeldung == null);
	    }

	    /**
	     * @return 'true', wenn dieser Befehl wird Erfolgreich geloescht .
	     */
	    public boolean loeschungErfolgreich()
	    {
	        return (loeschungHatNichtErfolgreich != null);
	    }
	    
	    
}
