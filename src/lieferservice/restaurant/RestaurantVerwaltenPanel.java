package lieferservice.restaurant;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;

import lieferservice.gui.GuiSettings;


@SuppressWarnings("serial")
public class RestaurantVerwaltenPanel extends JPanel {
	public final static String NAME = "RestaurantVerwaltenPanel";

	/**
	 * Uebaschrift Benennung und Stings ausgeben
	 */
	private static final String UEBA = "<html><b>Restaurant</b> verwalten";
//	private static final String NEU_UEBA = "<html><b><u>N</u>euer Benutzer</b>";
//	private static final String AEND_UEBA = "<html><b>Benutzer editieren</b>";
//	private static final String loes_UEBA= "<html><b>Benutzer löschen</b>";



	private static final String DAU_ERR = "DAU Error Erkennung";
	private static final String ERR_KEINE_BENUTZER_GEWAEHLT = "Kein Restaurant selektiert";
	private static final String LOESCHEN_RESTAURANT = "Restaurant löschen";
	private static final String SICHER_FRAGE = "<html>Wollen Sie wirklich das Restaurant <b>";
	private static final String LOESCHEN = "</b> löschen?";


	/**
	 * Groesse der Ueberschrift 
	 */

	private static final int HEADING_INSET_TOP = 5;
	private static final int HEADING_INSET_LEFT = 5;
	private static final int HEADING_INSET_BOTTOM = 5;
	private static final int HEADING_INSET_RIGHT = 5;

	/**
	 * Groesse des geiles Bildes
	 */
	private static final int ICAN_INSET_TOP = 0;
	private static final int ICAN_INSET_LEFT = 5;
	private static final int ICAN_INSET_BOTTOM = 0;
	private static final int ICAN_INSET_RIGHT = 25;


	/**
	 * Groesse der Table
	 */
	private static final int Table_INSET_TOP = 10;
	private static final int Table_INSET_RIGHT = 10;
	private static final int Table_INSET_BOTTOM = 10;
	private static final int Table_INSET_LEFT = 25;


	/**
	 * Groesse der Buttons
	 */
	private static final int BUTTON_INSET_RIGHT = 25;
	private static final int BUTTON_INSET_LEFT = 5;
	private static final int BUTTON_INSET_TOP = 5;
	private static final int BUTTON_INSET_BOTTOM = 0;

	public static final Object ERR_NO_SELECTION = null;

	public static final String ERR_TITLE = null;




	/**
	 * Variablen
	 */

	private RestaurantVerwaltenTable table;


	/**
	 * ActionListener fuer das NeuButton
	 */

	@SuppressWarnings("serial")
	private class NeuButtonListener extends AbstractAction {
		private RestaurantVerwaltenPanel ueberfenster;

		public NeuButtonListener (RestaurantVerwaltenPanel parent) {
			ueberfenster = parent;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			new EditRestaurantDialog (ueberfenster);
		}
	}

	/**
	 * ActionListener fuer das EditierenButton
	 */
	private class EditierenButtonActionListener implements ActionListener {
		private RestaurantVerwaltenPanel ueberfenster;

		public EditierenButtonActionListener (RestaurantVerwaltenPanel parent) {
			this.ueberfenster = parent;
		}
		public void actionPerformed (ActionEvent e) {
			int row = ueberfenster.table.getSelectedRow();
			if (row == -1) {
				JOptionPane.showMessageDialog(SwingUtilities.getRootPane(ueberfenster),ERR_KEINE_BENUTZER_GEWAEHLT, DAU_ERR, JOptionPane.ERROR_MESSAGE);

				return;
			}
			RestaurantVerwaltenTableModel model = (RestaurantVerwaltenTableModel) ueberfenster.table.getModel();
			Restaurant restaurant = model.getRestaurantInZeilen(row);
			new EditRestaurantDialog(ueberfenster, restaurant);
		}

	}



	/**
	 * ActionListener fuer das LoeschenButton
	 */
	private class LoeschenButtonListener implements ActionListener {
		private RestaurantVerwaltenPanel ueberfenster;

		public LoeschenButtonListener (RestaurantVerwaltenPanel parent) {
			this.ueberfenster = parent;
		}
		public void actionPerformed (ActionEvent e) {
			int row = ueberfenster.table.getSelectedRow();
			if (row == -1) {
				JOptionPane.showMessageDialog(SwingUtilities.getRootPane(ueberfenster), ERR_KEINE_BENUTZER_GEWAEHLT, DAU_ERR, JOptionPane.ERROR_MESSAGE);
				return;

			}
			RestaurantVerwaltenTableModel model = (RestaurantVerwaltenTableModel) ueberfenster.table.getModel();
			Restaurant restaurant = model.getRestaurantInZeilen(row);

			if (JOptionPane.showConfirmDialog(SwingUtilities.getRootPane(ueberfenster), SICHER_FRAGE + restaurant.getName() + LOESCHEN, LOESCHEN_RESTAURANT, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
				restaurant.auDatenbankLoeschen();
				ueberfenster.updateModel();
			}

		}
	}



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
		this.table = new RestaurantVerwaltenTable();

		rv.gridx = 0;
		rv.gridy = 1;
		rv.gridheight = 4;
		rv.gridwidth = 1;
		rv.weightx = 1;
		rv.weighty = 1;
		rv.fill = GridBagConstraints.BOTH;
		rv.insets = new Insets (Table_INSET_TOP, Table_INSET_LEFT, Table_INSET_BOTTOM, Table_INSET_RIGHT);
		JScrollPane scrollpane = new JScrollPane(this.table, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		this.add(scrollpane, rv);


		//geiles Bild reinbringen
		Image image;

		rv.gridx = 1;
		rv.gridy = 1;
		rv.gridheight = 1;
		rv.gridwidth = 1;
		rv.fill =GridBagConstraints.NONE;
		rv.weightx = 0;
		rv.weighty = 1;
		rv.insets = new Insets(ICAN_INSET_TOP, ICAN_INSET_LEFT, ICAN_INSET_BOTTOM, ICAN_INSET_RIGHT);
		ImageIcon bild = new ImageIcon("restaurant.png");
		image = bild.getImage();
		image = image.getScaledInstance(200, -1, Image.SCALE_SMOOTH);
		bild.setImage(image);
		this.add(new JLabel(bild), rv);


		/**
		 * Button New
		 */

		rv.gridx = 1;
		rv.gridy = 2;
		rv.gridheight = 1;
		rv.gridwidth = 1;
		rv.weightx=0;
		rv.weighty=0;
		rv.insets = new Insets(BUTTON_INSET_TOP, BUTTON_INSET_LEFT, BUTTON_INSET_BOTTOM, BUTTON_INSET_RIGHT);
		rv.fill = GridBagConstraints.HORIZONTAL;
		rv.anchor = GridBagConstraints.SOUTH;
		JButton neu = new JButton("Neu");
		neu.setBackground(GuiSettings.DEFAULT_HIGHLIGHT_COLOR);
		neu.setOpaque(true);
		neu.setBorderPainted(false);
		neu.setFont(GuiSettings.getTextFont(neu.getFont()));
		neu.addActionListener(new NeuButtonListener(this));
		this.add(neu, rv);


		/**
		 * Button editieren
		 */

		rv.gridx = 1;
		rv.gridy = 3;
		rv.gridheight = 1;
		rv.gridwidth = 1;
		rv.weightx=0;
		rv.weighty=0;
		rv.insets = new Insets(BUTTON_INSET_TOP, BUTTON_INSET_LEFT, BUTTON_INSET_BOTTOM, BUTTON_INSET_RIGHT);
		rv.fill = GridBagConstraints.HORIZONTAL;
		rv.anchor = GridBagConstraints.SOUTH;
		JButton editieren = new JButton("editieren");
		editieren.setBackground(GuiSettings.DEFAULT_HIGHLIGHT_COLOR);
		editieren.setOpaque(true);
		editieren.setBorderPainted(false);
		editieren.setFont(GuiSettings.getTextFont(editieren.getFont()));
		editieren.addActionListener(new EditierenButtonActionListener(this));
		this.add(editieren, rv);



		/**
		 * Button Loeschen
		 */
		rv.gridx = 1;
		rv.gridy = 4;
		rv.gridheight = 1;
		rv.gridwidth = 1;
		rv.weightx=0;
		rv.weighty=0;
		rv.insets = new Insets(BUTTON_INSET_TOP, BUTTON_INSET_LEFT, BUTTON_INSET_BOTTOM+10, BUTTON_INSET_RIGHT);
		rv.fill = GridBagConstraints.HORIZONTAL;
		rv.anchor = GridBagConstraints.SOUTH;
		JButton loeschen = new JButton("<html>L&ouml;schen");
		loeschen.setBackground(GuiSettings.DEFAULT_HIGHLIGHT_COLOR);
		loeschen.setOpaque(true);
		loeschen.setBorderPainted(false);
		loeschen.setFont(GuiSettings.getTextFont(loeschen.getFont()));
		loeschen.addActionListener(new LoeschenButtonListener(this));
		this.add(loeschen, rv);

	}



	/**
	 * Wenn die Datenbank sich verändert, wird auch unsere Table aktualisiert
	 */


	public void updateModel() {
		table.setModel(new RestaurantVerwaltenTableModel());
	}
}
