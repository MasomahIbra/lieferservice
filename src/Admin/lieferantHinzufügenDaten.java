package Admin;

import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.SwingConstants;

public class lieferantHinzufügenDaten extends JFrame {
	private JSeparator separator;
	private JLabel labelNewLabel;
	/**
	 * @wbp.nonvisual location=-10,89
	 */

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
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setForeground(new Color(102, 205, 170));
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 711, 526);
		getContentPane().setLayout(null);
		{
			separator = new JSeparator();
			separator.setBounds(10, 53, 675, 2);
			getContentPane().add(separator);
		}
		{
			JLabel TopTierLabel = new JLabel("TopTier");
			TopTierLabel.setOpaque(true);
			TopTierLabel.setHorizontalAlignment(SwingConstants.CENTER);
			TopTierLabel.setFont(new Font("Georgia", Font.BOLD, 25));
			TopTierLabel.setBackground(new Color(102, 205, 170));
			TopTierLabel.setForeground(new Color(255, 255, 255));
			TopTierLabel.setBounds(0, 0, 695, 54);
			getContentPane().add(TopTierLabel);
		}
		{

		}
	}
	
	protected void do_Suchen_actionPerformed(ActionEvent e) {
	}
}
