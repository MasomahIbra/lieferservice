package lieferservice.restaurant;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import lieferservice.gui.GuiSettings;

public class RestaurantVerwaltenPanel extends JPanel {
	public final static String NAME = "RestaurantVerwaltenPanel";

	/**
	 * UEbaschrift Benennung
	 */
	private static final String UEBA = "<html><b>Restaurant</b> verwalten";
	private static final String NEU_UEBA = "<html><b><u>N</u>euer Benutzer</b>";
	private static final String AEND_UEBA = "<html><b>Benutzer editieren</b>";
	private static final String loes_UEBA= "<html><b>Benutzer löschen</b>";
	
	
	
	/**
	 * Groesse der sUeberschrift 
	 */
	
	private static final int HEADING_INSET_TOP = 5;
	private static final int HEADING_INSET_LEFT = 5;
	private static final int HEADING_INSET_BUTTOM = 5;
	private static final int HEADING_INSET_RIGHT = 5;
	
	/**
	 * Groesse des geiles Bildes
	 */
	private static final int ICAN_INSET_TOP = 0;
	private static final int ICAN_INSET_LEFT = 5;
	private static final int ICAN_INSET_BUTTOM = 0;
	private static final int ICAN_INSET_RIGHT = 25;


	/**
	 * Groesse der Table
	 */
	private static final int Table_INSET_TOP = 10;
	private static final int Table_INSET_RIGHT = 10;
	private static final int Table_INSET_BUTTOM = 10;
	private static final int Table_INSET_LEFT = 25;


	/**
	 * Groesse der Buttons
	 */
	private static final int BUTTON_INSET_RIGHT = 25;
	private static final int BUTTON_INSET_LEFT = 5;
	private static final int BUTTON_INSET_TOP = 5;
	private static final int BUTTON_INSET_BUTTOM = 0;

	private static final int HEADING_INSET_BOTTOM = 0;
	
	
	private RestaurantVerwaltenTable table;


	/**
	 * Konstruktor 
	 */
	public RestaurantVerwaltenPanel () {
		super(new GridBagLayout());

		//GridBagLayout layout = new GridBagLayout();
		//this.setLayout(layout);

		GridBagConstraints  rv = new GridBagConstraints();
		rv.gridx = 0;
		rv.gridy = 0;
		rv.gridheight = 1;
		rv.gridwidth = 1;
		rv.insets = new Insets(HEADING_INSET_TOP, HEADING_INSET_LEFT, HEADING_INSET_BOTTOM, HEADING_INSET_RIGHT);
		JLabel titel = new JLabel(UEBA);
		titel.setFont(GuiSettings.getHeadingFont(titel.getFont()));
		this.add(titel, rv);

		/**
		 * Hintergrundfarbe festlegen
		 */ 
		this.setBackground(GuiSettings.DEFAULT_BACKGROUND_COLOR);

		
		/**
		 * Table in der RestaurantveraltenPanel aufbauen
		 */
		RestaurantVerwaltenTable table = new RestaurantVerwaltenTable();

		rv.gridx = 0;
		rv.gridy = 1;
		rv.gridheight = 4;
		rv.gridwidth = 1;
		rv.weightx = 1;
		rv.weighty = 1;
		rv.fill = GridBagConstraints.BOTH;
		rv.insets = new Insets (Table_INSET_TOP, Table_INSET_LEFT, Table_INSET_BUTTOM, Table_INSET_RIGHT);
		JScrollPane scrollpane = new JScrollPane(table, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		this.add(scrollpane, rv);

		
		//geiles Bild reinbringen
		Image image;

		rv.gridx = 1;
		rv.gridy = 1;
		rv.gridheight = 1;
		rv.gridwidth = 1;
		rv.fill =GridBagConstraints.NONE;
		rv.weightx = 0;
		rv.weighty = 0;
		rv.insets = new Insets(ICAN_INSET_TOP, ICAN_INSET_LEFT, ICAN_INSET_BUTTOM, ICAN_INSET_RIGHT);
		ImageIcon bild = new ImageIcon("restaurant.png");
		image = bild.getImage();
		image = image.getScaledInstance(100, -1, Image.SCALE_SMOOTH);
		bild.setImage(image);
		this.add(new JLabel(bild), rv);

		
		/**
		 * Button New
		 */

		rv.gridx = 1;
		rv.gridy = 2;
		rv.gridheight = 1;
		rv.gridwidth = 1;
		rv.insets = new Insets(BUTTON_INSET_TOP, BUTTON_INSET_LEFT, BUTTON_INSET_BUTTOM, BUTTON_INSET_RIGHT);
		JButton neu = new JButton("Neu");
		neu.setOpaque(true);
		neu.setBorderPainted(false);
		neu.setFont(GuiSettings.getTextFont(neu.getFont()));
		this.add(neu, rv);


		/**
		 * Button Ändern
		 */

		rv.gridx = 1;
		rv.gridy = 3;
		rv.gridheight = 1;
		rv.gridwidth = 1;
		rv.insets = new Insets(BUTTON_INSET_TOP, BUTTON_INSET_LEFT, BUTTON_INSET_BUTTOM, BUTTON_INSET_RIGHT);
		JButton editieren = new JButton("editieren");
		editieren.setOpaque(true);
		editieren.setBorderPainted(false);
		this.add(editieren, rv);



		/**
		 * Button Loeschen
		 */
		rv.gridx = 1;
		rv.gridy = 4;
		rv.gridheight = 1;
		rv.gridwidth = 1;
		rv.insets = new Insets(BUTTON_INSET_TOP, BUTTON_INSET_LEFT, BUTTON_INSET_BUTTOM, BUTTON_INSET_RIGHT);
		JButton loeschen = new JButton("<html>L&ouml;schen");
		loeschen.setOpaque(true);
		loeschen.setBorderPainted(false);
		this.add(loeschen, rv);

	}

	/**
	 * Wenn die Datenbank sich verändert, wird auch unsere Table aktualisiert
	 */

	//public void updatetable () {
	//	table.setModel(new RestaurantVerwaltenTableModel());
	//}
}
