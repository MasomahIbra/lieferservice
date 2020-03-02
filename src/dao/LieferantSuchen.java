package dao;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LieferantSuchen extends JFrame {

	private JPanel contentPane;
	private JLabel labelSuchbegrifflndername;
	private JTextField textField;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LieferantSuchen frame = new LieferantSuchen();
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
	public LieferantSuchen() {
		initGUI();
	}
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 447);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		{
			labelSuchbegrifflndername = new JLabel("Adresse :");
			labelSuchbegrifflndername.setBounds(10, 11, 165, 39);
			contentPane.add(labelSuchbegrifflndername);
		}
		{
			textField = new JTextField();
			textField.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					do_textField_keyReleased(e);
				}
			});
			textField.setBounds(75, 20, 388, 20);
			contentPane.add(textField);
			textField.setColumns(10);
		}

		{
			textArea = new JTextArea();
			textArea.setBounds(0, 57, 494, 352);
			contentPane.add(textArea);
		}
	}
	protected void do_textField_keyReleased(KeyEvent e) {
		

		try {
			// Datenbankklasse dynamisch erzeugen.
			Class.forName ("org.sqlite.JDBC");

			// Verbindung initialisieren.
			String datei = "pp.db";
			String url = "jdbc:sqlite:" + datei;
			Connection conn =  DriverManager.getConnection (url);

			// Erzeugen einer SQL-Anweisung.
			String sql = "SELECT * from Essen where name like ?";
			PreparedStatement statement = conn.prepareStatement (sql);
			statement.setString(1, "%"+this.textField.getText()+"%");


			// SQL-Anweisung ausf�hren.
			ResultSet resultSet = statement.executeQuery();
			String ausgabe="";
			//  Daten auslesen Datensatzzeiger auf den ersten Datensatz setzen.
			while(resultSet.next()) { 
				// Daten auslesen.
				String text = resultSet.getString("Name");
				text +=", " + resultSet.getString("Kategorie");
				text +=", " + resultSet.getString("Preis");
				text+=", " + resultSet.getString("Groesse");
				;
				ausgabe+=text+"\n";
			}
			this.textArea.setText(ausgabe);

	} catch (ClassNotFoundException er) {
		er.printStackTrace();
	} catch (SQLException er) {
		// TODO Auto-generated catch block
		er.printStackTrace();
		}
	}
	
}
