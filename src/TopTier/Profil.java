package TopTier;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Profil extends Panelvorlage {
	private JButton buttonZurStartseite;

	public Profil(MainGui maingui) {
		super(maingui);
		this.setUeberschrift("Lieferanten");
		initGUI();
	}
	private void initGUI() {
		setLayout(null);
		{
			buttonZurStartseite = new JButton("Zur Startseite");
			this.beautifyButton(buttonZurStartseite);
			buttonZurStartseite.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					buttonZurStartseiteActionPerformed(e);
				}
			});
			buttonZurStartseite.setBounds(36, 170, 141, 35);
			add(buttonZurStartseite);
		}
	}
	protected void buttonZurStartseiteActionPerformed(ActionEvent e) {
		maingui.switchTo(v.startseite);
	}
}
