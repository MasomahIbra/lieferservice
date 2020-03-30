package lieferservice.gui;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JToolBar;

import lieferservice.Benutzer;

/**
 * Diese Klasse stellt die Statuszeile für unser Programm dar.
 * @author MasoumehIbrahimi
 *
 */
public class Statuszeile extends JPanel {
	
	JLabel 	angemeldeterBenutzer,
			statusMeldung;
	
	
	/**
	 * Create the panel.
	 */
	public Statuszeile() {
		setBackground(Color.WHITE);
		setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		angemeldeterBenutzer = new JLabel("New label");
		updateAngemeldeterBenutzer();
		add(angemeldeterBenutzer);
	}

	
	/**
	 * Setzt den Text für den angemeldeten Benutzer
	 */
	public void updateAngemeldeterBenutzer() {
		String s = "angemeldeter Benutzer: " + Benutzer.getAngemeldeterBenutzer().getName();
		s = s + "   ";
		
		angemeldeterBenutzer.setText(s);
	}
	
	
	/**
	 * Setzt den Text für eine Meldung
	 */
	public void setStatusMeldung(String neuerText) {
		statusMeldung.setText(neuerText);
	}

}
