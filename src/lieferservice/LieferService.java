package lieferservice;

import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import lieferservice.gui.MainJFrame;

/**
 * Diese Klasse enthält die main-Methode, über die das Programm gestartet wird.
 * @author MasoumehIbrahimi
 *
 */
public class LieferService {

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					//Datenbank.befehlAusfuehren("INSERT INTO Benutzer (Name, Passwort, ProgrammAdministrator, RestaurantAdministrator, BestellungsBearbeiter, Abrechner) VALUES ('Admin', 'opa', 'J', 'J', 'J', 'J')");
					
					MainJFrame frame = new MainJFrame();

					frame.setVisible(true);
					frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);

				} catch (Exception e) {
					
					JOptionPane.showMessageDialog(null, e.getMessage());
					e.printStackTrace();
				}
			}
		});
	}

}
