package Admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Component;
import javax.swing.border.CompoundBorder;
import javax.swing.UIManager;
import java.awt.Font;

public class lieferantHinzufügenDaten extends JFrame {
	private JLabel labelAuswahl;
	private JPanel panel;
	private JSeparator separator;
	private JLabel labelNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lieferantHinzufügenDaten frame = new lieferantHinzufügenDaten();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public lieferantHinzufügenDaten() {
		initGUI();
	}
	private void initGUI() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 711, 526);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			labelAuswahl = new JLabel("Kategorie Auswahl");
			labelAuswahl.setFont(new Font("Segoe UI", Font.PLAIN, 33));
			labelAuswahl.setForeground(Color.BLACK);
			labelAuswahl.setBorder(new CompoundBorder());
			labelAuswahl.setBackground(Color.WHITE);
			labelAuswahl.setBounds(189, 0, 406, 109);
			contentPane.add(labelAuswahl);
			labelAuswahl.setOpaque(true);
		}
		{
			panel = new JPanel();
			panel.setBounds(10, 120, 631, -3);
			contentPane.add(panel);
		}
		{
			separator = new JSeparator();
			separator.setBounds(10, 115, 675, 2);
			contentPane.add(separator);
		}
		{
			labelNewLabel = new JLabel("");
			labelNewLabel.setIcon(new ImageIcon("LOGO.png"));
			labelNewLabel.setBounds(35, 211, 310, 156);
			contentPane.add(labelNewLabel);
		}
	}
}
