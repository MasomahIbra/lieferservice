/**
 * 
 */
package lieferservice.gui.benutzer;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
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
import lieferservice.restaurant.Restaurant;

/**
 * Dieser Dialog dient zum Erzeugen neuer Benutzer sowie zum Editieren bestehender Benutzer
 * @author masomahibrahimi
 *
 */
@SuppressWarnings("serial")
public class EditBenutzerDialog extends JDialog {

	private Benutzer benutzer;	// zu editierender Benutzer. Ist null, wenn ein neuer Benutzer angelegt werden soll
	private BenutzerVerwaltenPanel parentPanel;
	private Restaurant restaurant;




	JTextField txtName;
	JPasswordField txtPassword1, txtPassword2;



	/* Strings */
	private final static String NEW_USER_TITLE = "Neuer Benutzer";
	private final static String EDIT_USER_TITLE = "Benutzer editieren";

	private final static String TXT_NAME = "Benutzername";
	private final static String TXT_PASSWORD1 = "Passwort";
	private final static String TXT_PASSWORD2 = "Passwort wiederholen";
	private final static String TXT_SAVE = "Speichern";
	private final static String TXT_CANCEL = "Abbruch";

	private final static String ERR_TITLE = "ts ts - Kopfschüttel";
	private final static String ERR_INVALID_NAME = "Ungültiger Benutzername";
	private final static String ERR_AMBIGUOUS_NAME = "Benutzername wird schon verwendet";
	private final static String ERR_PASSWORD_NOT_IDENTICAL = "Ich will ja nicht unnötig rummeckern, aber für die nächste " +
			"Anmeldung wäre es bestimmt hilfreich, wenn die beiden Passwörter übereinstimmen würden.";

	private final static String FILENAME_OK = "ok.png";
	private final static String FILENAME_CANCEL = "cancel.png";


	/**
	 * ActionEventListener des OK-Buttons
	 */
	public class OkButtonListener implements ActionListener {

		EditBenutzerDialog parentWindow;


		public OkButtonListener(EditBenutzerDialog parent) {
			this.parentWindow = parent;
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			// Prüfen, ob der Benutzername gültig ist
			if (!Benutzer.isGueltigerBenutzername(parentWindow.txtName.getText())) {
				JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(parentWindow), ERR_INVALID_NAME, 
						ERR_TITLE, JOptionPane.ERROR_MESSAGE);
				return;
			}

			// Sicherstellen, dass ein Benutzername nicht zweimal verwendet wird
			int id = Benutzer.idDesBenutzernamens(parentWindow.txtName.getText());

			if (parentWindow.benutzer == null) {

				// Neuer Benutzer - dann darf der Benutzername nicht schon vergeben sein
				if (id != Benutzer.ILLEGAL_ID) {
					JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(parentWindow), ERR_AMBIGUOUS_NAME, 
							ERR_TITLE, JOptionPane.ERROR_MESSAGE);
					return;
				}
			}

			// Vorhandener Benutzer: der Name darf für diesen Benutzer schon vorhanden sein - aber auch nur da
			else if ((id != Benutzer.ILLEGAL_ID) && (id != parentWindow.benutzer.getId())) {
				JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(parentWindow), ERR_PASSWORD_NOT_IDENTICAL, 
						ERR_TITLE, JOptionPane.ERROR_MESSAGE);
				return;
			}

			// Die Passwörter müssen identisch sein
			String p1 = new String(parentWindow.txtPassword1.getPassword());
			String p2 = new String(parentWindow.txtPassword2.getPassword());

			if (!p1.contentEquals(p2)) {
				JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(parentWindow), ERR_PASSWORD_NOT_IDENTICAL, 
						ERR_TITLE, JOptionPane.ERROR_MESSAGE);
				return;
			}

			// Ok, die Prüfungen sind erledigt und wir sind glücklich. Dann wollen wir mal speichern
			if (parentWindow.benutzer == null) {
				Benutzer.benutzerAnlegen(txtName.getText(), new String(txtPassword1.getPassword()));
			}
			else {
				parentWindow.benutzer.setName(txtName.getText());
				parentWindow.benutzer.setPassword(new String(txtPassword1.getPassword()));
			}
			parentWindow.setVisible(false);
			parentWindow.parentPanel.updateModel();
		}
	}


	/**
	 * ActionEventListener des Cancel-Buttons
	 */
	private class CancelButtonListener extends AbstractAction {
		private EditBenutzerDialog parentWindow;

		CancelButtonListener(EditBenutzerDialog parent) {
			this.parentWindow = parent;
		}
		

		@Override
		public void actionPerformed(ActionEvent e) {
			this.parentWindow.setVisible(false);
		}

	}
	

	/**
	 * Konstruktor, wenn ein neuer Benutzer angelegt werden soll
	 * @param parentWindow übergeordnetes Fenster
	 */
	public EditBenutzerDialog(BenutzerVerwaltenPanel parentWindow) {
		super((JFrame) SwingUtilities.getWindowAncestor(parentWindow), NEW_USER_TITLE, true);
		this.benutzer = null;
		this.parentPanel = parentWindow;
		fensterBauen();
	}

	/**
	 * Konstruktor für den Dialog, wenn ein bestehender Benutzer editiert werden soll
	 * @param parentWindow übergeordnetes Fenster
	 * @param zuEditierenderBenutzer zu editierender Benutzer
	 */
	public EditBenutzerDialog(BenutzerVerwaltenPanel parentWindow, Benutzer zuEditierenderBenutzer) {
		super((JFrame) SwingUtilities.getWindowAncestor(parentWindow), EDIT_USER_TITLE, true);
		this.benutzer = zuEditierenderBenutzer;
		this.parentPanel = parentWindow;
		fensterBauen();
	}

	/**
	 * Baut das Fenster auf
	 */
	private void fensterBauen() {
		setBounds(150, 140, 500, 250);
		setAlwaysOnTop(true);
		setResizable(false);
		getContentPane().setBackground(GuiSettings.DEFAULT_HIGHLIGHT_COLOR);

		GridBagLayout layout = new GridBagLayout();
		this.setLayout(layout);

		GridBagConstraints gc = new GridBagConstraints();

		// Label für den Benutzernamen
		gc.gridx = 0;
		gc.gridy = 0;
		gc.gridwidth = 1;
		gc.gridheight=1;
		gc.weightx=0.1;
		gc.weighty=0;
		gc.insets = new Insets(10,20,10,10);
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(new JLabel(TXT_NAME),gc);

		// Textfeld für den Benutzernamen
		gc.gridx = 1;
		gc.gridy = 0;
		gc.gridwidth = 1;
		gc.gridheight=1;
		gc.weightx=0.9;
		gc.weighty=0;
		gc.insets = new Insets(10, 0,10,20);
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		txtName = new JTextField();
		if (benutzer != null) {
			txtName.setText(benutzer.getName());
		}
		add(txtName, gc);

		// Label für 1. Passworteingabe
		gc.gridx = 0;
		gc.gridy = 1;
		gc.gridwidth = 1;
		gc.gridheight=1;
		gc.weightx=0.1;
		gc.weighty=0;
		gc.insets = new Insets(10,20,10,10);
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(new JLabel(TXT_PASSWORD1),gc);

		// 1. Passworteingabe
		gc.gridx = 1;
		gc.gridy = 1;
		gc.gridwidth = 1;
		gc.gridheight=1;
		gc.weightx=0.9;
		gc.weighty=0;
		gc.insets = new Insets(10, 0,10,20);
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		txtPassword1 = new JPasswordField();
		if (benutzer != null) {
			txtPassword1.setText(benutzer.getPassword());
		}
		add(txtPassword1, gc);

		// Label für die 2. Passworteingabe
		gc.gridx = 0;
		gc.gridy = 2;
		gc.gridwidth = 1;
		gc.gridheight=1;
		gc.weightx=0.1;
		gc.weighty=0;
		gc.insets = new Insets(10,20,10,10);
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(new JLabel(TXT_PASSWORD2),gc);

		// 2. Passworteingabe
		gc.gridx = 1;
		gc.gridy = 2;
		gc.gridwidth = 1;
		gc.gridheight=1;
		gc.weightx=0.9;
		gc.weighty=0;
		gc.insets = new Insets(10, 0,10,20);
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		txtPassword2 = new JPasswordField();
		if (benutzer != null) {
			txtPassword2.setText(benutzer.getPassword());
		}
		add(txtPassword2, gc);

		// Panel für die Buttons
		gc.gridx = 0;
		gc.gridy = 3;
		gc.gridwidth = 2;
		gc.gridheight=1;
		gc.weightx=0.1;
		gc.weighty=0.0;
		gc.insets = new Insets(10, 0,10,20);
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.anchor = GridBagConstraints.LAST_LINE_END;
		JPanel buttonPanel = new JPanel();
		add(buttonPanel, gc);
		buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		buttonPanel.setBackground(GuiSettings.DEFAULT_HIGHLIGHT_COLOR);

		// OK-Button
		ImageIcon icon = new ImageIcon(FILENAME_OK);
		Image image = icon.getImage();
		image = image.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		icon.setImage(image);

		JButton okButton = new JButton(TXT_SAVE, icon);
		okButton.addActionListener(new OkButtonListener(this));
		buttonPanel.add(okButton);
		SwingUtilities.getRootPane(this).setDefaultButton(okButton);

		// Cancel-Button
		icon = new ImageIcon(FILENAME_CANCEL);
		image = icon.getImage();
		image = image.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		icon.setImage(image);

		JButton cancelButton = new JButton(TXT_CANCEL, icon);
		cancelButton.addActionListener(new CancelButtonListener(this));
		buttonPanel.add(cancelButton);

		setVisible(true);
	}


	/**
	 * Konstruktor für den Restaurant-Verwalten Dialog, wenn ein bereits bestehendes Restaurant
	 * editiert werden soll
	 * @param ueberfenster Mutter-Fenster
	 * @param zuEditierenderRestaurant das zu editierende Restaurant
	 */
	public EditBenutzerDialog(BenutzerVerwaltenPanel ueberfenster, Restaurant zuEditierenderRestaurant) {
		super((JFrame) SwingUtilities.getWindowAncestor(ueberfenster), EDIT_USER_TITLE, true);
		this.restaurant = zuEditierenderRestaurant;
		this.parentPanel = ueberfenster;
		fensterAufbauen();
	}


	/**
	 * Baut das Fenster auf
	 */
	private void fensterAufbauen() {
		setBounds(150, 140, 500, 250);
		setAlwaysOnTop(true);
		setResizable(false);
		getContentPane().setBackground(GuiSettings.DEFAULT_HIGHLIGHT_COLOR);

		GridBagLayout layout = new GridBagLayout();
		this.setLayout(layout);

		GridBagConstraints gc = new GridBagConstraints();

		// Label für den Restaurantnamen
		gc.gridx = 0;
		gc.gridy = 0;
		gc.gridwidth = 1;
		gc.gridheight=1;
		gc.weightx=0.1;
		gc.weighty=0;
		gc.insets = new Insets(10,20,10,10);
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(new JLabel(TXT_NAME),gc);

		// Textfeld für den Restaurantnamen
		gc.gridx = 1;
		gc.gridy = 0;
		gc.gridwidth = 1;
		gc.gridheight=1;
		gc.weightx=0.9;
		gc.weighty=0;
		gc.insets = new Insets(10, 0,10,20);
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		txtName = new JTextField();
		if (restaurant != null) {
			txtName.setText(restaurant.getName());
		}
		add(txtName, gc);

		// Label für 1. Passworteingabe
		gc.gridx = 0;
		gc.gridy = 1;
		gc.gridwidth = 1;
		gc.gridheight=1;
		gc.weightx=0.1;
		gc.weighty=0;
		gc.insets = new Insets(10,20,10,10);
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(new JLabel(TXT_PASSWORD1),gc);

		// 1. Passworteingabe
		gc.gridx = 1;
		gc.gridy = 1;
		gc.gridwidth = 1;
		gc.gridheight=1;
		gc.weightx=0.9;
		gc.weighty=0;
		gc.insets = new Insets(10, 0,10,20);
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		txtPassword1 = new JPasswordField();
		if (restaurant != null) {
			txtPassword1.setText(benutzer.getPassword());
		}
		add(txtPassword1, gc);

		// Label für die 2. Passworteingabe
		gc.gridx = 0;
		gc.gridy = 2;
		gc.gridwidth = 1;
		gc.gridheight=1;
		gc.weightx=0.1;
		gc.weighty=0;
		gc.insets = new Insets(10,20,10,10);
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(new JLabel(TXT_PASSWORD2),gc);

		// 2. Passworteingabe
		gc.gridx = 1;
		gc.gridy = 2;
		gc.gridwidth = 1;
		gc.gridheight=1;
		gc.weightx=0.9;
		gc.weighty=0;
		gc.insets = new Insets(10, 0,10,20);
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.anchor = GridBagConstraints.FIRST_LINE_END;
		txtPassword2 = new JPasswordField();
		if (restaurant != null) {
			txtPassword2.setText(benutzer.getPassword());
		}
		add(txtPassword2, gc);

		// Panel für die Buttons
		gc.gridx = 0;
		gc.gridy = 3;
		gc.gridwidth = 2;
		gc.gridheight=1;
		gc.weightx=0;
		gc.weighty=0;
		gc.insets = new Insets(10, 0,10,20);
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.anchor = GridBagConstraints.LAST_LINE_END;
		JPanel buttonPanel = new JPanel();
		add(buttonPanel, gc);
		buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		buttonPanel.setBackground(GuiSettings.DEFAULT_HIGHLIGHT_COLOR);

		// OK-Button
		ImageIcon icon = new ImageIcon(FILENAME_OK);
		Image image = icon.getImage();
		image = image.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		icon.setImage(image);

		JButton okButton = new JButton(TXT_SAVE, icon);
		okButton.addActionListener(new OkButtonListener(this));
		buttonPanel.add(okButton);
		SwingUtilities.getRootPane(this).setDefaultButton(okButton);

		// Cancel-Button
		icon = new ImageIcon(TXT_CANCEL);
		image = icon.getImage();
		image = image.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		icon.setImage(image);

		JButton cancelButton = new JButton(TXT_CANCEL, icon);
		cancelButton.addActionListener(new CancelButtonListener(this));
		buttonPanel.add(cancelButton);

		setVisible(true);
	}

	

}



