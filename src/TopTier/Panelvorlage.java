package TopTier;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;

public class Panelvorlage extends JPanel {
	private JTextField Ueberschrift;
	protected Views v;
	protected MainGui maingui;

	/**
	 * Create the panel.
	 */
	public Panelvorlage(MainGui maingui) {
		this.maingui = maingui;
		initGUI();
	}
	private void initGUI() {
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);
		{
			Ueberschrift = new JTextField();
			Ueberschrift.setBackground(Color.CYAN);
			Ueberschrift.setForeground(Color.BLACK);
			Ueberschrift.setHorizontalAlignment(SwingConstants.CENTER);
			Ueberschrift.setEditable(false);
			Ueberschrift.setFont(new Font("Tahoma", Font.PLAIN, 30));
			Ueberschrift.setBounds(0, 0, 450, 53);
			add(Ueberschrift);
			Ueberschrift.setColumns(10);
		}
	}
	
	public void setUeberschrift(String Ueberschrift) {
		this.Ueberschrift.setText(Ueberschrift);
	}
	
	public void beautifyButton(JButton btn) {
		btn.setBackground(Color.CYAN);
		btn.setForeground(Color.BLACK);
	}
	
}