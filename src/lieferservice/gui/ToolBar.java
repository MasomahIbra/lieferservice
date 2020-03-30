/**
 * 
 */
package lieferservice.gui;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import lieferservice.Benutzer;

import java.util.Vector;

/**
 * Diese Klasse definiert die Toolbar für das Programm.
 * 
 * @author masomahibrahimi
 *
 */
public class ToolBar extends JPanel {

	// Größe der Buttons
	private static final int BUTTON_WIDTH = 30;
	private static final int BUTTON_HEIGHT = 30;
	
	// Dateinamen
	private static final String FILENAME_LOGIN = "login.png";
	private static final String FILENAME_LOGOUT = "logout.png";
	private static final String FILENAME_USER = "user.png";
	private static final String FILENAME_RESTAURANT = "restaurant.png";
	
	// Tooltip-Texte
	private static final String LOGIN_TOOLTIP = "Anmelden";
	private static final String LOGOFF_TOOLTIP = "Abmelden";
	private static final String USER_TOOLTIP = "Benutzer verwalten";
	private static final String RESTAURANT_TOOLTIP = "Restaurants verwalten";
	
	
	// Die Buttons
	private JButton loginButton;
	private JButton logoffButton;
	private JButton manageUsersButton;
	private JButton manageRestaurantsButton;
	
	
	/**
	 * Erstellt ein Icon aus dem Bild mit dem angegebenen Dateinamen in der Buttongröße
	 * @param filename Dateiname des Bildes
	 * @return Icon
	 */
	private ImageIcon loadIcon(String filename) {
		ImageIcon icon;
		Image image;
		
		icon = new ImageIcon(filename);
		image = icon.getImage();
		image = image.getScaledInstance(BUTTON_WIDTH, BUTTON_HEIGHT, Image.SCALE_SMOOTH);
		icon.setImage(image);
		return icon;
	}
	
	
	/**
	 * Konstruktor
	 */
	public ToolBar(ActionListener loginListener,
			ActionListener logoffListener,
			ActionListener benutzerVerwaltenListener,
			ActionListener restaurantVerwaltenListener) {
		
		FlowLayout layout = new FlowLayout();
		layout.setAlignment(FlowLayout.LEFT);
		setLayout(layout);
		
		setBackground(GuiSettings.DEFAULT_HIGHLIGHT_COLOR);
		setBorder(BorderFactory.createRaisedBevelBorder());
		
		loginButton = new JButton(loadIcon(FILENAME_LOGIN));
		loginButton.setToolTipText(LOGIN_TOOLTIP);
		loginButton.addActionListener(loginListener);
		add(loginButton);
		
		logoffButton = new JButton(loadIcon(FILENAME_LOGOUT));
		logoffButton.setToolTipText(LOGOFF_TOOLTIP);
		logoffButton.addActionListener(logoffListener);
		add(logoffButton);
		
		manageUsersButton = new JButton(loadIcon(FILENAME_USER));
		manageUsersButton.setToolTipText(USER_TOOLTIP);
		add (manageUsersButton);
		
		manageRestaurantsButton = new JButton(loadIcon(FILENAME_RESTAURANT));
		manageRestaurantsButton.setToolTipText(RESTAURANT_TOOLTIP);
		add(manageRestaurantsButton);
	}
	
	
	/**
	 * Setzt die Sichtbarkeit der Buttons anhand der Rechte des angemeldeten Benutzers
	 */
	public void setzeSichtbarkeitDerButtons() {
		Benutzer benutzer = Benutzer.getAngemeldeterBenutzer();
		
		manageUsersButton.setVisible(benutzer.isProgrammAdministrator());
		manageRestaurantsButton.setVisible(benutzer.isProgrammAdministrator());
	}
}
