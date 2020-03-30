package lieferservice.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import lieferservice.Benutzer;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 * Dieses Fenster ist der Anmeldedialog für den Benutzer. Er stellt zwei Textfelder für Benutzername und Passwort sowie
 * zwei Buttons für Bestätigung und Abbruch zur Verfügung.
 * 
 * Er ist ziemlich häßlich. Sprich: nicht rosa und benutzt ein AbsoluteLayout.
 * 
 * @author masomahibrahimi
 *
 */
public class BenutzerAnmeldenFenster extends JDialog {
	private JTextField txtBenutzername;
	private JPasswordField txtPasswort;
	
	private MainJFrame mama;
	
	
	/* 
	 * Diese Klasse stellt den Action-Listener für den Cancel-Button dar
	 */
	private class CancelButtonActionListener implements ActionListener {
		private BenutzerAnmeldenFenster meinFenster;
		
		CancelButtonActionListener(BenutzerAnmeldenFenster f){
			this.meinFenster = f;
		}
		
		public void actionPerformed(ActionEvent e) {
			meinFenster.setVisible(false);
		}
	}
	
	
	/* 
	 * Diese Klasse stellt den Action-Listener für den OK-Button dar
	 */
	private class OkButtonActionListener implements ActionListener {
		private BenutzerAnmeldenFenster meinFenster;
		
		OkButtonActionListener(BenutzerAnmeldenFenster f){
			this.meinFenster = f;
		}
		
		public void actionPerformed(ActionEvent e) {
			String pw = new String(txtPasswort.getPassword());
			
			if (!Benutzer.benutzerAnmelden(txtBenutzername.getText(), pw)) {
				JOptionPane.showMessageDialog(meinFenster, "Benutzername oder Passwort falsch", "Fehler", JOptionPane.ERROR_MESSAGE);
				System.out.println("Benutzer anmelden fehlgeschlagen");
			} else {
				meinFenster.setVisible(false);
				meinFenster.mama.fensterFuerBenutzerAnpassen();
				System.out.println("Benutzer angemeldet");
			}
		}
	}


	/**
	 * Create the dialog.
	 */
	public BenutzerAnmeldenFenster(MainJFrame parentWindow) {
		super(parentWindow, "Benutzer anmelden", true);
		
		mama = parentWindow;
		
		setResizable(false);
		setBounds(150, 140, 450, 300);
		setAlwaysOnTop(true);
		getContentPane().setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 239, 450, 39);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				okButton.addActionListener(new OkButtonActionListener(this));
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new CancelButtonActionListener(this));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		{
			JLabel lblNewLabel = new JLabel("Benutzername");
			lblNewLabel.setBounds(25, 46, 94, 16);
			getContentPane().add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Passwort");
			lblNewLabel_1.setBounds(25, 85, 61, 16);
			getContentPane().add(lblNewLabel_1);
		}
		{
			txtBenutzername = new JTextField();
			txtBenutzername.setBounds(160, 40, 150, 26);
			getContentPane().add(txtBenutzername);
			txtBenutzername.setColumns(10);
		}
		{
			txtPasswort = new JPasswordField();
			txtPasswort.setAlignmentX(Component.RIGHT_ALIGNMENT);
			txtPasswort.setBounds(160, 80, 150, 26);
			txtPasswort.setColumns(10);
			txtPasswort.setEchoChar('*');
			getContentPane().add(txtPasswort);
		}
		setVisible(true);
	}
	
}
