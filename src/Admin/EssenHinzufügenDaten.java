package Admin;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.EventQueue;

import java.awt.Color;
import javax.swing.SwingConstants;

public class EssenHinzufügenDaten extends JFrame {

	private JSeparator separator;
	private JLabel labelNewLabel;
	/**
	 * @wbp.nonvisual location=-10,89
	 */


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EssenHinzufügenDaten frame = new EssenHinzufügenDaten();

	}

	/**
	 * Create the frame.
	 */
	public EssenHinzufügenDaten() {
		initGUI();
	}
	private void initGUI() {
		setVisible(true);
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



			if(e.getSource()== btnLÖSCHEN)
			{
				Connection conn = null; //Verbindung zum Server
				Statement stmt = null;  //die abzusetzende SQL-Anweisung
				try
				{
					Class.forName("com.mysql.jdbc.Driver").newInstance();
					Fehler.setText("Treiber OK.");
					conn = DriverManager.getConnection("jdbc:mysql://10.1.123.215/dvdverleih?user=software&password=verleih");
					Fehler.setText("Verbindung erhalten: " + conn.toString());
				}
				catch (Exception ex)
				{
					Fehler.setText("Fehler beim Verbindungsaufbau!" + ex.toString()); 
				} 

			}
		}

	}
}
}
