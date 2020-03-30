package lieferservice.gui;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class GastPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4666239369493758886L;
	
	public static final String NAME = "GastPanel";

	/**
	 * Create the panel.
	 */
	public GastPanel() {
		JLabel panelText = new JLabel("Du bist ein Gast!");
		this.add(panelText, BorderLayout.CENTER);
		
	}

}
