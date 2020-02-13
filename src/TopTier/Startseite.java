package TopTier;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Startseite extends Panelvorlage {
	private JButton buttonZumProfil;
	private JButton buttonImpressum;

	public Startseite(MainGui maingui) {
		super(maingui);
		this.setUeberschrift("TopTier LieferService");
		initGUI();
	}
	private void initGUI() {
		setLayout(null);
		{
			buttonZumProfil = new JButton("Lieferanten");
			this.beautifyButton(buttonZumProfil);
			buttonZumProfil.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					buttonZumProfilActionPerformed(arg0);
				}
			});
			buttonZumProfil.setBounds(36, 170, 141, 35);
			add(buttonZumProfil);
		}
		{
			buttonImpressum = new JButton("Warenkorb");
			this.beautifyButton(buttonImpressum);
			buttonImpressum.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					buttonImpressumActionPerformed(e);
				}
			});
			buttonImpressum.setBounds(263, 170, 141, 35);
			add(buttonImpressum);
		}
	}
	protected void buttonZumProfilActionPerformed(ActionEvent arg0) {
		maingui.switchTo(v.profil);
	}
	protected void buttonImpressumActionPerformed(ActionEvent e) {
		maingui.switchTo(v.impressum);
	}
}