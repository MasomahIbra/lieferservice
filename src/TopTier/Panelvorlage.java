package TopTier;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JLabel;

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
			Ueberschrift.setBounds(61, 0, 389, 64);
			add(Ueberschrift);
			Ueberschrift.setColumns(10);
			
		}
		
		JLabel Foto = new JLabel("");
		Foto.setIcon(new ImageIcon("H:\\eclipse\\workspace\\lieferservice\\img\\toptier.png"));
		Foto.setBounds(0, 0, 62, 64);
		add(Foto);
	}
	
	private void setIconImage(Image image) {
		// TODO Auto-generated method stub
		
	}
	public void setUeberschrift(String Ueberschrift) {
		this.Ueberschrift.setText(Ueberschrift);
	}
	
	public void beautifyButton(JButton btn) {
		btn.setBackground(Color.WHITE);
		btn.setForeground(Color.BLACK);
	}
	private Object getCodeBase() {
		// TODO Auto-generated method stub
		return null;
	}
}