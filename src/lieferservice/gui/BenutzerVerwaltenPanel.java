package lieferservice.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListModel;

public class BenutzerVerwaltenPanel extends JPanel {

	private static final long serialVersionUID = 1540396857152616311L;
	public final static String NAME = "BenutzerVerwaltenPanel";
	
	JList benutzerListe;
	
	
	/**
	 * Create the panel.
	 * @return 
	 */
	public  BenutzerVerwaltenPanel() {
		super(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		
		// Fensterüberschrift dem Panel hinzufügen
		gc.gridx = 0;
		gc.gridy=0;
		gc.gridwidth=1;
		gc.gridheight=1;
		add(new JLabel("Benutzer verwalten"), gc);
		
		// Liste dem Panel hinzufügen
		Vector<String> v = new Vector<String>();
		v.add("Hallo");
		v.add("Masoumeh");
		v.add("wie");
		v.add("geht's?");
		
		benutzerListe = new JList<String>(v);
		benutzerListe.setBackground(Color.WHITE);
		gc.gridx = 0;
		gc.gridy = 1;
		gc.gridwidth = 1;
		gc.gridheight=4;
		gc.weightx=0.9;
		gc.weighty=0.9;
		add(benutzerListe, gc);
		
		// Neuer Benutzer Button hinzufügen
		gc.gridx = 1;
		gc.gridy = 2;
		gc.gridwidth=1;
		gc.gridheight=1;
		gc.weightx=0.1;
		gc.weighty=0.1;
		JButton neuerBenutzerButton = new JButton("neu");
		add(neuerBenutzerButton, gc);
		
		
		// Benutzer editieren Button hinzufügen
		gc.gridx = 1;
		gc.gridy = 3;
		gc.gridwidth=1;
		gc.gridheight=1;
		gc.weightx=0.1;
		gc.weighty=0.1;
		JButton editBenutzerButton = new JButton("editieren");
		add(editBenutzerButton, gc);
		
		// Benutzer löschen Button hinzufügen
		gc.gridx = 1;
		gc.gridy = 4;
		gc.gridwidth=1;
		gc.gridheight=1;
		gc.weightx=0.1;
		gc.weighty=0.1;
		JButton benutzerLoeschenButton = new JButton("löschen");
		add(benutzerLoeschenButton, gc);
		
	}

}