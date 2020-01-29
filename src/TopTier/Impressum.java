package TopTier;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Impressum extends Panelvorlage {
	private JLabel labelImpressum;
	private JButton buttonStartseite;

	/**
	 * Create the panel.
	 */
	public Impressum(MainGui maingui) {
		super(maingui);
		this.setUeberschrift("Warenkorb");
		initGUI();
	}
	private void initGUI() {
		setLayout(null);
		{
			labelImpressum = new JLabel("Impressum");
			labelImpressum.setFont(new Font("Tahoma", Font.PLAIN, 30));
			labelImpressum.setBounds(21, 21, 207, 26);
			add(labelImpressum);
		}
		{
			buttonStartseite = new JButton("Startseite");
			this.beautifyButton(buttonStartseite);
			buttonStartseite.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					buttonStartseiteActionPerformed(e);
				}
			});
			buttonStartseite.setBounds(36, 170, 141, 35);
			add(buttonStartseite);
		}
		{
			buttonStartseite = new JButton("Warenkorb leeren");
			this.beautifyButton(buttonStartseite);
			buttonStartseite.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					buttonStartseiteActionPerformed(e);
				}
			});
			buttonStartseite.setBounds(263, 170, 141, 35);
			add(buttonStartseite);
		}
	}
	protected void buttonStartseiteActionPerformed(ActionEvent e) {
		maingui.switchTo(v.startseite);
	}
}
