package lieferservice.gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

import lieferservice.Benutzer;
import lieferservice.gui.benutzer.BenutzerVerwaltenPanel;
import lieferservice.restaurant.RestaurantVerwaltenPanel;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JLabel;

public class MainJFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1913790062656889560L;
	private Statuszeile statuszeile;
	private JMenu mnuAdministrator;
	private JPanel kartenPanel; // Das ist das Panel mit dem Cards Layout
	private ToolBar toolbar;

	/*
	 * Das ist der Action-Listener für den Menüeintrag "Benutzer anmelden"
	 */
	private class BenutzerAnmeldenListener implements ActionListener {
		private MainJFrame parentWindow;

		public BenutzerAnmeldenListener(MainJFrame parent) {
			this.parentWindow = parent;
		}


		public void actionPerformed(ActionEvent e) {
			BenutzerAnmeldenFenster f = new BenutzerAnmeldenFenster(parentWindow);
		}
	}
	
	
	
	/*
	 * Das ist der Action-Listener für das Abmelden des Benutzers
	 */
	private class BenutzerAbmeldenListener implements ActionListener {
		private MainJFrame parentWindow;
		
		public BenutzerAbmeldenListener(MainJFrame parent) {
			this.parentWindow = parent;
		}
		
		public void actionPerformed(ActionEvent e) {
			Benutzer.abmelden();
			fensterFuerBenutzerAnpassen();
		}
	}
	
	
	/**
	 * Das ist der Action-Listener für den "Benutzer verwalten"-Button
	 */
	private class BenutzerVerwaltenButtonListener implements ActionListener {

		private JPanel kartenPanel;
		
		/**
		 * Konstruktor
		 */
		public BenutzerVerwaltenButtonListener(JPanel panel) {
			this.kartenPanel = panel;
		}
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			CardLayout layout = (CardLayout) kartenPanel.getLayout();
			layout.show(this.kartenPanel, BenutzerVerwaltenPanel.NAME);	
		}
	}
	
	
	/**
	 * Das ist der Action-Listener für den "Benutzer verwalten"-Button
	 */
	private class RestaurantVerwaltenButtonListener implements ActionListener {

		private JPanel kartenPanel;
		
		/**
		 * Konstruktor
		 */
		public RestaurantVerwaltenButtonListener(JPanel panel) {
			this.kartenPanel = panel;
		}
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			CardLayout layout = (CardLayout) kartenPanel.getLayout();
			layout.show(this.kartenPanel, RestaurantVerwaltenPanel.NAME);	
		}
		
	}


	/**
	 * Create the frame.
	 */
	public MainJFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		// Kartenpanel aufbauen
		kartenPanel = new JPanel(new CardLayout());
		kartenPanel.add(new BenutzerVerwaltenPanel(), BenutzerVerwaltenPanel.NAME);
		kartenPanel.add(new GastPanel(), GastPanel.NAME);
		kartenPanel.add(new RestaurantVerwaltenPanel(), RestaurantVerwaltenPanel.NAME);
		
		// Menü aufbauen
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		// Datei-Menü aufbauen
		JMenu mnuDatei = new JMenu("Datei");
		mnuDatei.setMnemonic(KeyEvent.VK_D); // TODO - noch nicht fertig / das funktioniert noch nicht
		menuBar.add(mnuDatei);

		JMenuItem mi_BenutzerAnmelden = new JMenuItem("anmelden");
		mi_BenutzerAnmelden.addActionListener(new BenutzerAnmeldenListener(this));
		mi_BenutzerAnmelden.setMnemonic(KeyEvent.VK_N); // TODO - noch nicht fertig / das funktioniert noch nicht
		mnuDatei.add(mi_BenutzerAnmelden);

		JMenuItem mi_BenutzerAbmelden = new JMenuItem("abmelden");
		mi_BenutzerAbmelden.addActionListener(new BenutzerAbmeldenListener(this));
		mnuDatei.add(mi_BenutzerAbmelden);
		
		mnuDatei.addSeparator();
		
		JMenuItem mi_ProgrammBeenden = new JMenuItem("Programm beenden");
		mi_ProgrammBeenden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnuDatei.add(mi_ProgrammBeenden);

		// Administrator-Menü aufbauen
		mnuAdministrator = new JMenu("Administrator");
		menuBar.add(mnuAdministrator);

		JMenuItem mi_BenutzerVerwalten = new JMenuItem("Benutzer verwalten");
		mi_BenutzerVerwalten.addActionListener(new BenutzerVerwaltenButtonListener(kartenPanel));
		mnuAdministrator.add(mi_BenutzerVerwalten);
		
		JMenuItem mi_RestaurantsVerwalten = new JMenuItem("Restaurants verwalten");
		mi_RestaurantsVerwalten.addActionListener(new RestaurantVerwaltenButtonListener(kartenPanel));
		mnuAdministrator.add(mi_RestaurantsVerwalten);
		

		CardLayout cardLayout = (CardLayout) kartenPanel.getLayout();
		cardLayout.show(kartenPanel, GastPanel.NAME);
		add(kartenPanel, BorderLayout.CENTER);
		
		// Toolbar aufbauen
		this.toolbar = new ToolBar(new BenutzerAnmeldenListener(this),
				new BenutzerAbmeldenListener(this),
				new BenutzerVerwaltenButtonListener(kartenPanel),
				new RestaurantVerwaltenButtonListener(kartenPanel));
		add(toolbar, BorderLayout.PAGE_START);
		
		// Statuszeile aufbauen
		statuszeile = new Statuszeile();
		add(statuszeile, BorderLayout.PAGE_END);
		pack();

		fensterFuerBenutzerAnpassen();
	}
	
	
	/**
	 * Führt ein Update der Anzeige des angemeldeten Benutzers durch
	 */
	private void updateAngemeldeterBenutzer() {
		statuszeile.updateAngemeldeterBenutzer();
	}
	
	
	/**
	 * Setzt den Text der Statuszeile
	 */
	public void setStatusZeilenText(String neuerText) {
		statuszeile.setStatusMeldung(neuerText);
	}
	
	
	
	
	/**
	 * Diese Funktion wird aufgerufen, wenn sich ein Benutzer anmeldet oder abmeldet oder
	 * wenn das Hauptfenster neu augemacht wird
	 */
	public void fensterFuerBenutzerAnpassen() {
		setzeSichtbarkeitderMenuesImHauptfenster();
		setzePanelFuerNeuAngemeldetenBenutzer();
		toolbar.setzeSichtbarkeitDerButtons();
		updateAngemeldeterBenutzer();
	}
	
	
	/**
	 * Setzt die Menüs sichtbar, die der aktive Benutzer verwenden darf
	 */
	private void setzeSichtbarkeitderMenuesImHauptfenster() {
		Benutzer benutzer = Benutzer.getAngemeldeterBenutzer();
		
		mnuAdministrator.setVisible(benutzer.isProgrammAdministrator());
		
	}
	
	
	/**
	 * Setzt das aktive Panel entsprechend den Rechten des aktuell (neu angemeldeten) Benutzers
	 */
	private void setzePanelFuerNeuAngemeldetenBenutzer() {
		Benutzer benutzer = Benutzer.getAngemeldeterBenutzer();
		
		CardLayout cardLayout = (CardLayout) kartenPanel.getLayout();
		if (benutzer.isProgrammAdministrator()) {
			cardLayout.show(kartenPanel, BenutzerVerwaltenPanel.NAME);
		}
		else {
			cardLayout.show(kartenPanel, GastPanel.NAME);
		}
	}

}
