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
import javax.swing.SwingConstants;

public class lieferantHinzufügenDaten extends JFrame {
	private JPanel panel;
	private JLabel labelÜberschrift;

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
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			panel = new JPanel();
			panel.setBounds(10, 120, 631, -3);
			contentPane.add(panel);
		}
		{
			labelÜberschrift = new JLabel("TopTier");
			labelÜberschrift.setFont(new Font("Georgia", Font.ITALIC, 30));
			labelÜberschrift.setHorizontalAlignment(SwingConstants.CENTER);
			labelÜberschrift.setOpaque(true);
			labelÜberschrift.setBackground(new Color(102, 205, 170));
			labelÜberschrift.setBounds(0, 0, 695, 56);
			contentPane.add(labelÜberschrift);
		}
	}
}
