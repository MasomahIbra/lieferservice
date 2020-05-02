/**
 * 
 */
package lieferservice.restaurant;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import lieferservice.Benutzer;
import lieferservice.gui.GuiSettings;
import lieferservice.gui.MainJFrame;
import lieferservice.gui.benutzer.BenutzerVerwaltenPanel;
import lieferservice.restaurant.Restaurant;
import lieferservice.restaurant.RestaurantVerwaltenPanel;

/**
 * Dieser Dialog dient zum Erzeugen neuer Restaurant sowie zum Editieren bestehender Restaurant
 * @author masomahibrahimi
 *
 */
public class EditRestaurantDialog extends JDialog {

private RestaurantVerwaltenPanel parentPanel;
private Restaurant restaurant;


//	private Restaurant restaurant;
//	private RestaurantVerwaltenPanel ueberfenster;
//
public EditRestaurantDialog(RestaurantVerwaltenPanel ueberfenster) {
super((JFrame) SwingUtilities.getWindowAncestor(ueberfenster), true);
	this.restaurant = null;
	this.parentPanel = ueberfenster;
	fensterBauen();
	}

	
	
	public EditRestaurantDialog(RestaurantVerwaltenPanel ueberfenster, Restaurant zuEditierenderrestaurant) {
		super((JFrame)SwingUtilities.getWindowAncestor(ueberfenster), true);
		this.restaurant = zuEditierenderrestaurant;
		this.parentPanel = ueberfenster;
		fensterBauen();
	}




	private void fensterBauen() {
		
		
	}
	



}
