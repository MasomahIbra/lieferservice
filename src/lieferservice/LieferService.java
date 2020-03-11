package lieferservice;

import javax.swing.JFrame;

import lieferservice.gui.MainJFrame;

/**
 * Diese Klasse enth�lt die main-Methode, �ber die das Programm gestartet wird.
 * @author MasoumehIbrahimi
 *
 */
public class LieferService {

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					MainJFrame frame = new MainJFrame();

					frame.setVisible(true);
					frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}