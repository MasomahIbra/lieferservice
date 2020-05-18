package lieferservice.restaurant;
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
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import lieferservice.gui.GuiSettings;
import lieferservice.gui.benutzer.EditBenutzerDialog.OkButtonListener;




/**
 * Dieser Dialog dient zum Erzeugen neuer Restaurants sowie zum Editieren bestehender Restaurants
 * @author masomahibrahimi
 *
 */
@SuppressWarnings("serial")
public class EditRestaurantDialog extends JDialog {

	private RestaurantVerwaltenPanel parentPanel;
	private Restaurant restaurant;

	
	private JLabel labRestaurantName;
	private JTextField txtRestaurantName;
	private JLabel labRestaurantKategorie;
	private JTextField txtRestaurantKategorie;
	private JLabel labAdresse;
	private JTextField txtAdresse;
	private JLabel labTelefon;
	private JTextField txtTelefon;
	private JLabel labEmail;
	private JTextField txtEmail;
	private JButton OKButton;
	private JButton CancelButton;
	
	private final static String NEW_Restaurant_TITLE = "Neues Restaurant";
	private final static String EDIT_Restaurant_TITLE = "Restaurant editieren";
	
	private final static String TXT_RESTAURANTNAME = "Restaurantname";
	private final static String TXT_RESTAURANTKATEGORIE = "Restaurantkategorie";
	private final static String TXT_ADRESSE = "Adresse";
	private final static String TXT_TELEFON = "Telefon";
	private final static String TXT_EMAIL = "Email";
	private final static String TXT_SPEICHERN = "Speichern";
	private final static String TXT_ABBRUCH = "Abbruch";
	
	
	
	private final static String ERR_TITLE = "DAU Error";
	private final static String ERR_INVALID_NAME = "Ungültiger Restaurantname";
	private final static String ERR_AMBIGUOUS_NAME = "Restaurantname wird schon verwendet";
	private final static String ERR_PASSWORD_NOT_IDENTICAL = "Passwoerte uebereinstimmen nicht !";



	
	private final static String BILD_OK = "ok.png";
	private final static String BILD_CANCEL = "cancel.png";


	/**
	 * Listener für den OK-Button, der die Eingabe übernimmt
	 */
	private class OkButtonActionListener implements ActionListener {
		EditRestaurantDialog ueberfenster;

		public OkButtonActionListener (EditRestaurantDialog parent) {
			this.ueberfenster = parent;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			ueberfenster.setVisible(false);	
			ueberfenster.parentPanel.updateModel();
		}
	}
	

	/**
	 * ActionEventListener des Cancel-Buttons
	 */
	private class CancelButtonListener implements ActionListener {
		private EditRestaurantDialog ueberfenster;
		
		public CancelButtonListener(EditRestaurantDialog ueberFenster) {
			this.ueberfenster = ueberFenster;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			this.ueberfenster.setVisible(false);
		}
	}
	

	/**
	 * Dieser Konstruktor wird benutzt, um ein neues Restaurant anzulegen
	 * @param ueberfenster Übergeordnetes Fenster
	 */
	public EditRestaurantDialog(RestaurantVerwaltenPanel ueberfenster) {
		super((JFrame)SwingUtilities.getWindowAncestor(ueberfenster), NEW_Restaurant_TITLE, true);
		this.restaurant = new Restaurant();
		this.parentPanel = ueberfenster;
		neuesFesnsterAufbauen();
	}



	/**
	 * Dieser Konstruktor wird benutzt, wenn ein vorhandenes Restaurant editiert werden soll.
	 * @param ueberfenster übergeordnetes Fenster
	 * @param restaurant zu editierendes Restaurant
	 */
	public EditRestaurantDialog(RestaurantVerwaltenPanel ueberfenster, Restaurant restaurant) {
		super((JFrame)SwingUtilities.getWindowAncestor(ueberfenster), EDIT_Restaurant_TITLE, true);
		this.restaurant = restaurant;
		this.parentPanel = ueberfenster;
		neuesFesnsterAufbauen();		
	}

	/**
	 * Neues Fenster aufbauen 
	 */
	private void neuesFesnsterAufbauen() {
	setBounds(150, 140, 500, 250);
	setAlwaysOnTop(true);
	setResizable(false);
	getContentPane().setBackground(GuiSettings.DEFAULT_HIGHLIGHT_COLOR);
	
	
	GridBagLayout layout = new GridBagLayout();
	this.setLayout(layout);
	
	
	GridBagConstraints nf = new GridBagConstraints();
	
	
	
	//Label für dan Restaurantname
	nf.gridx = 0;
	nf.gridy = 0;
	nf.gridheight = 1;
	nf.gridwidth = 1;
	nf.weightx = 0.1;
	nf.weighty = 0;
	nf.insets = new Insets(10, 20, 10, 10);
	nf.fill = GridBagConstraints.NONE;
	nf.anchor = GridBagConstraints.FIRST_LINE_START;
	add(new JLabel(TXT_RESTAURANTNAME), nf);
	
	// JTextField für den Restaurantname
	nf.gridx = 1;
	nf.gridy = 0;
	nf.gridheight = 1;
	nf.gridwidth = 2;
	nf.weightx = 0.9;
	nf.weighty = 0;
	nf.insets = new Insets(0, 0, 0, 0);
	nf.fill = GridBagConstraints.HORIZONTAL;
	nf.anchor = GridBagConstraints.FIRST_LINE_END;
	txtRestaurantName = new JTextField();
	if (restaurant != null) {
		txtRestaurantName.setText(restaurant.getName());
	}
	add(txtRestaurantName, nf);
	
	
	
	//Label für die Kategorie
		nf.gridx = 0;
		nf.gridy = 1;
		nf.gridheight = 1;
		nf.gridwidth = 1;
		nf.weightx = 0.1;
		nf.weighty = 0;
		nf.insets = new Insets(10, 20, 10, 10);
		nf.fill = GridBagConstraints.NONE;
		nf.anchor = GridBagConstraints.FIRST_LINE_START;
		add(new JLabel(TXT_RESTAURANTKATEGORIE), nf);
		
		// JTextField für die Kategorie
		nf.gridx = 1;
		nf.gridy = 1;
		nf.gridheight = 1;
		nf.gridwidth = 2;
		nf.weightx = 0.9;
		nf.weighty = 0;
		nf.insets = new Insets(0, 0, 0, 0);
		nf.fill = GridBagConstraints.HORIZONTAL;
		nf.anchor = GridBagConstraints.FIRST_LINE_END;
		txtRestaurantKategorie = new JTextField();
		if (restaurant != null) {
			txtRestaurantKategorie.setText(restaurant.getRestaurantkategorie());
		}
		add(txtRestaurantKategorie, nf);
		
		
		
		//Label für die Adresse
			nf.gridx = 0;
			nf.gridy = 2;
			nf.gridheight = 1;
			nf.gridwidth = 1;
			nf.weightx = 0.1;
			nf.weighty = 0;
			nf.insets = new Insets(10, 20, 10, 10);
			nf.fill = GridBagConstraints.NONE;
			nf.anchor = GridBagConstraints.FIRST_LINE_START;
			add(new JLabel(TXT_ADRESSE), nf);
			
			// JTextField für die Adresse
			nf.gridx = 1;
			nf.gridy = 2;
			nf.gridheight = 1;
			nf.gridwidth = 2;
			nf.weightx = 0.9;
			nf.weighty = 0;
			nf.insets = new Insets(0, 0, 0, 0);
			nf.fill = GridBagConstraints.HORIZONTAL;
			nf.anchor = GridBagConstraints.FIRST_LINE_END;
			txtAdresse = new JTextField();
			if (restaurant != null) {
				txtAdresse.setText(restaurant.getAdresse());
			}
			add(txtAdresse, nf);
			
		
			//Label für die Telefon
			nf.gridx = 0;
			nf.gridy = 3;
			nf.gridheight = 1;
			nf.gridwidth = 1;
			nf.weightx = 0.1;
			nf.weighty = 0;
			nf.insets = new Insets(10, 20, 10, 10);
			nf.fill = GridBagConstraints.NONE;
			nf.anchor = GridBagConstraints.FIRST_LINE_START;
			add(new JLabel(TXT_TELEFON), nf);
			
			// JTextField für die Adresse
			nf.gridx = 1;
			nf.gridy = 3;
			nf.gridheight = 1;
			nf.gridwidth = 2;
			nf.weightx = 0.9;
			nf.weighty = 0;
			nf.insets = new Insets(0, 0, 0, 0);
			nf.fill = GridBagConstraints.HORIZONTAL;
			nf.anchor = GridBagConstraints.FIRST_LINE_END;
			txtTelefon = new JTextField();
			if (restaurant != null) {
				txtTelefon.setText(restaurant.getTelefon());
			}
			add(txtTelefon, nf);
		
			
			//Label für die Email
			nf.gridx = 0;
			nf.gridy = 4;
			nf.gridheight = 1;
			nf.gridwidth = 1;
			nf.weightx = 0.1;
			nf.weighty = 0;
			nf.insets = new Insets(10, 20, 10, 10);
			nf.fill = GridBagConstraints.NONE;
			nf.anchor = GridBagConstraints.FIRST_LINE_START;
			add(new JLabel(TXT_EMAIL), nf);
			
			// JTextField für die Email
			nf.gridx = 1;
			nf.gridy = 4;
			nf.gridheight = 1;
			nf.gridwidth = 2;
			nf.weightx = 0.9;
			nf.weighty = 0;
			nf.insets = new Insets(0, 0, 0, 0);
			nf.fill = GridBagConstraints.HORIZONTAL;
			nf.anchor = GridBagConstraints.FIRST_LINE_END;
			txtEmail = new JTextField();
			if (restaurant != null) {
				txtEmail.setText(restaurant.getEmail());
			}
			add(txtEmail, nf);
		
			
			//Panel für die Buttons
			nf.gridx = 0;
			nf.gridy = 5;
			nf.gridwidth = 2;
			nf.gridheight=1;
			nf.weightx=0.1;
			nf.weighty=0.0;
			nf.insets = new Insets(10, 0,10,20);
			nf.fill = GridBagConstraints.HORIZONTAL;
			nf.anchor = GridBagConstraints.LAST_LINE_END;
			JPanel buttonPanel = new JPanel();
			add(buttonPanel, nf);
			buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
			buttonPanel.setBackground(GuiSettings.DEFAULT_HIGHLIGHT_COLOR);
			
			
			// OK-Button-Bild
			ImageIcon icon = new ImageIcon(BILD_OK);
			Image bild = icon.getImage();
			bild = bild.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
			icon.setImage(bild);

			JButton okButton = new JButton(TXT_SPEICHERN, icon);
			okButton.addActionListener(new OkButtonActionListener(this));
			buttonPanel.add(okButton);
			SwingUtilities.getRootPane(this).setDefaultButton(okButton);

			// Abbruch-Button-Bild
			icon = new ImageIcon(BILD_CANCEL);
			bild = icon.getImage();
			bild = bild.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
			icon.setImage(bild);

			JButton AbbruchButton = new JButton(TXT_ABBRUCH, icon);
			AbbruchButton.addActionListener(new CancelButtonListener(this));
			buttonPanel.add(AbbruchButton);

			setVisible(true);
	}
	}

