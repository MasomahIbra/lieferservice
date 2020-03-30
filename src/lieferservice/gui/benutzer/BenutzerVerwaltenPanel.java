package lieferservice.gui.benutzer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.SwingUtilities;

import lieferservice.Benutzer;
import lieferservice.gui.GuiSettings;
import lieferservice.gui.MainJFrame;


public class BenutzerVerwaltenPanel extends JPanel {

	private static final long serialVersionUID = 1540396857152616311L;
	public final static String NAME = "BenutzerVerwaltenPanel";
	
	
	/*
	 * Strings mit den Texten der Benutzerverwaltung
	 */
	private static final String TITEL_STR = "<html><b>Benutzer</b> verwalten <font color=\"blue\">(c) <i>Masomah <u>Ibrahimi</u></i></font> 2020";
	private static final String NEW_STR = "<html><b><u>N</u>euer Benutzer</b>";
	private static final String EDIT_STR = "<html><b>Benutzer editieren</b>";
	private static final String DELETE_STR = "<html><b>Benutzer löschen</b>";
	
	private static final String ERR_TITLE = "OSI Level 8 Error";
	private static final String ERR_NO_SELECTION = "Kein Benutzer selektiert";
	private static final String CONFIRM_DELETE_TITLE = "Benutzer löschen";
	private static final String CONFIRM_DELETE_MSG1 = "<html>Wollen Sie wirklich den Benutzer <b>";
	private static final String CONFIRM_DELETE_MSG2 = "</b> löschen?";
			
	/*
	 * Dateiname des Bildes
	 */
	private static final String IMAGE_FILENAME = "user.png";
	
	/*
	 * Randabstände der Überschrift
	 */
	private static final int HEADING_INSET_TOP = 5;
	private static final int HEADING_INSET_LEFT = 5;
	private static final int HEADING_INSET_BOTTOM = 5;
	private static final int HEADING_INSET_RIGHT = 5;
	
	/*
	 * Randabstände der Tabelle
	 */
	private static final int TABLE_INSET_TOP = 10;
	private static final int TABLE_INSET_LEFT = 25;
	private static final int TABLE_INSET_BOTTOM = 10;
	private static final int TABLE_INSET_RIGHT = 10;

	/*
	 * Randabstände der Buttons
	 */
	private static final int BUTTON_INSET_TOP = 5;
	private static final int BUTTON_INSET_LEFT = 5;
	private static final int BUTTON_INSET_BOTTOM = 5;
	private static final int BUTTON_INSET_RIGHT = 25;
	
	/*
	 * Randabstände des Bildes
	 */
	private static final int ICON_INSET_TOP = 0;
	private static final int ICON_INSET_LEFT= 5;
	private static final int ICON_INSET_BOTTOM = 0;
	private static final int ICON_INSET_RIGHT = 25;
	
	
	/*
	 *  Variablen
	 */
	private BenutzerVerwaltenTable table;
			
	
	/**
	 * ActionListener des NEW-Buttons
	 */
	private class NewButtonActionListener implements ActionListener {
		
		private BenutzerVerwaltenPanel parentWindow;
		
		public NewButtonActionListener(BenutzerVerwaltenPanel parent) {
			parentWindow = parent;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			new EditBenutzerDialog(parentWindow);
		}
	}
	
	
	
	/**
	 * ActionListener des Edit-Buttons
	 */
	private class EditButtonActionListener implements ActionListener {
		private BenutzerVerwaltenPanel parentWindow;
		
		public EditButtonActionListener(BenutzerVerwaltenPanel parent) {
			this.parentWindow = parent;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			int row = parentWindow.table.getSelectedRow();
			if (row == -1) {
				JOptionPane.showMessageDialog(SwingUtilities.getRootPane(parentWindow), ERR_NO_SELECTION, ERR_TITLE, 
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			BenutzerVerwaltenTableModel model = (BenutzerVerwaltenTableModel)  parentWindow.table.getModel();
			Benutzer benutzer = model.getBenutzerInZeile(row);
			new EditBenutzerDialog(parentWindow, benutzer);
		}
	}
	
	
	/**
	 * ActionListener des Delete-Buttons
	 */
	private class DeleteButtonListener implements ActionListener {
		private BenutzerVerwaltenPanel parentWindow;
		
		public DeleteButtonListener(BenutzerVerwaltenPanel parent) {
			this.parentWindow = parent;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			int row = parentWindow.table.getSelectedRow();
			if (row == -1) {
				JOptionPane.showMessageDialog(SwingUtilities.getRootPane(parentWindow), ERR_NO_SELECTION, ERR_TITLE, 
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			BenutzerVerwaltenTableModel model = (BenutzerVerwaltenTableModel)  parentWindow.table.getModel();
			Benutzer benutzer = model.getBenutzerInZeile(row);
			
			if (JOptionPane.showConfirmDialog(SwingUtilities.getRootPane(parentWindow),
					CONFIRM_DELETE_MSG1 + benutzer.getName() + CONFIRM_DELETE_MSG2,
					CONFIRM_DELETE_TITLE,
					JOptionPane.YES_NO_OPTION,
					JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
					benutzer.ausDatenbankLoeschen();
					parentWindow.updateModel();
			}
		}
	}
	
	/**
	 * Create the panel.
	 */
	public  BenutzerVerwaltenPanel() {
		super(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		
		// Fensterüberschrift dem Panel hinzufügen
		gc.gridx = 0;
		gc.gridy=0;
		gc.gridwidth=1;
		gc.gridheight=1;
		gc.insets = new Insets(HEADING_INSET_TOP, HEADING_INSET_LEFT, HEADING_INSET_BOTTOM, HEADING_INSET_RIGHT);
		JLabel titel = new JLabel(TITEL_STR);
		titel.setFont(GuiSettings.getHeadingFont(titel.getFont()));
		add(titel, gc);
		
		// Tabelle mit den Benutzereinträgen erzeugen
		table = new BenutzerVerwaltenTable(new BenutzerVerwaltenTableModel());
		
		gc.gridx = 0;
		gc.gridy = 1;
		gc.gridwidth = 1;
		gc.gridheight=4;
		gc.weightx=0.9;
		gc.weighty=0.9;
		gc.insets = new Insets(TABLE_INSET_TOP, TABLE_INSET_LEFT, TABLE_INSET_BOTTOM, TABLE_INSET_RIGHT);
		gc.fill = GridBagConstraints.BOTH;
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane, gc);

		// Geiles Bild
		gc.gridx = 1;
		gc.gridy = 1;
		gc.gridwidth=1;
		gc.gridheight=1;
		gc.weightx=0.1;
		gc.weighty=0.99;
		gc.insets=new Insets(ICON_INSET_TOP, ICON_INSET_LEFT, ICON_INSET_BOTTOM, ICON_INSET_RIGHT);
		gc.fill = GridBagConstraints.VERTICAL;
		gc.anchor = GridBagConstraints.SOUTH;
		ImageIcon image = new ImageIcon(IMAGE_FILENAME);
		add(new JLabel(image), gc);

		
		// Font für die Buttons definieren
		// Neuer Benutzer Button hinzufügen
		gc.gridx = 1;
		gc.gridy = 2;
		gc.gridwidth=1;
		gc.gridheight=1;
		gc.weightx=0.1;
		gc.weighty=0.01;
		gc.insets = new Insets(BUTTON_INSET_TOP, BUTTON_INSET_LEFT, BUTTON_INSET_BOTTOM, BUTTON_INSET_RIGHT);
		gc.fill = GridBagConstraints.BOTH;
		gc.anchor = GridBagConstraints.SOUTH;
		JButton neuerBenutzerButton = new JButton(NEW_STR);
		neuerBenutzerButton.setBackground(GuiSettings.DEFAULT_HIGHLIGHT_COLOR);
		neuerBenutzerButton.setOpaque(true);
		neuerBenutzerButton.setBorderPainted(false);
		neuerBenutzerButton.setFont(GuiSettings.getTextFont(neuerBenutzerButton.getFont()));
		neuerBenutzerButton.addActionListener(new NewButtonActionListener(this));
		add(neuerBenutzerButton, gc);
		
		
		// Benutzer editieren Button hinzufügen
		gc.gridx = 1;
		gc.gridy = 3;
		gc.gridwidth=1;
		gc.gridheight=1;
		gc.weightx=0.1;
		gc.weighty=0.01;
		gc.insets = new Insets(BUTTON_INSET_TOP, BUTTON_INSET_LEFT, BUTTON_INSET_BOTTOM, BUTTON_INSET_RIGHT);
		gc.fill = GridBagConstraints.BOTH;
		gc.anchor = GridBagConstraints.SOUTH;
		JButton editBenutzerButton = new JButton(EDIT_STR);
		editBenutzerButton.setBackground(GuiSettings.DEFAULT_HIGHLIGHT_COLOR);
		editBenutzerButton.setOpaque(true);
		editBenutzerButton.setBorderPainted(false);
		editBenutzerButton.setFont(GuiSettings.getTextFont(editBenutzerButton.getFont()));
		editBenutzerButton.addActionListener(new EditButtonActionListener(this));
		add(editBenutzerButton, gc);
		
		// Benutzer löschen Button hinzufügen
		gc.gridx = 1;
		gc.gridy = 4;
		gc.gridwidth=1;
		gc.gridheight=1;
		gc.weightx=0.1;
		gc.weighty=0.01;
		gc.insets = new Insets(BUTTON_INSET_TOP, BUTTON_INSET_LEFT, BUTTON_INSET_BOTTOM, BUTTON_INSET_RIGHT);
		gc.fill = GridBagConstraints.BOTH;
		gc.anchor = GridBagConstraints.SOUTH;
		JButton benutzerLoeschenButton = new JButton(DELETE_STR);
		benutzerLoeschenButton.setBackground(GuiSettings.DEFAULT_HIGHLIGHT_COLOR);
		benutzerLoeschenButton.setOpaque(true);
		benutzerLoeschenButton.setBorderPainted(false);
		benutzerLoeschenButton.setFont(GuiSettings.getTextFont(benutzerLoeschenButton.getFont()));
		benutzerLoeschenButton.addActionListener(new DeleteButtonListener(this));
		add(benutzerLoeschenButton, gc);
		
		// Hintergrundfarbe setzen
		this.setBackground(GuiSettings.DEFAULT_BACKGROUND_COLOR);
	}

	
	/**
	 * Führt ein Update der Tabelle durch, wenn sich außerhalb des Dialogs die Datenbankdaten geändert haben
	 */
	public void updateModel() {
		table.setModel(new BenutzerVerwaltenTableModel());
	}
}
