package TopTier;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.net.Inet4Address;

import javax.swing.JButton;

public class LieferantenHinzufügenPanel extends JFrame {

	private JPanel contentPane;

	private boolean nameOK=false;
	private JButton Speichern;
	private JTextField Name2;
	private JTextField Name2_1;
	private JTextField Adresse2;
	private JTextField Besitzer2;
	private JTextField Telefonnummer2;
	private JTextField Email2;
	private JTextField Restaurantkategorie2;
	private JTextField KurzeBeschreibung2;
	private JLabel Name;
	private JLabel Adresse;
	private JLabel Besitzer;
	private JLabel Telefonnummer;
	private JLabel Email;
	private JLabel Restaurantkategorie;
	private JLabel KurzeBeschreibung;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LieferantenHinzufügenPanel frame = new LieferantenHinzufügenPanel();
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
	public LieferantenHinzufügenPanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 735, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("FORMULAR");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(291, 26, 150, 36);
		contentPane.add(lblNewLabel);

		Name2 = new JTextField();
		Name2.setEditable(true);
		Name2.addFocusListener(new FocusAdapter() {
		});

		JPanel panel = new JPanel();
		panel.setBounds(517, 86, 140, 178);
		contentPane.add(panel);

		Speichern = new JButton("Speichern");
		Speichern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_Speichern_actionPerformed(e);
			}
		});
		Speichern.setBounds(291, 410, 117, 29);
		contentPane.add(Speichern);

		Name2_1 = new JTextField();
		Name2_1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_Name2_1_focusLost(e);
			}
			@Override
			public void focusGained(FocusEvent e) {
				do_Name2_1_focusGained(e);
			}
		});
		Name2_1.setColumns(10);
		Name2_1.setBounds(181, 86, 260, 26);
		contentPane.add(Name2_1);

		Adresse2 = new JTextField();
		Adresse2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_Adresse2_focusLost(e);
			}
			@Override
			public void focusGained(FocusEvent e) {
				do_Adresse2_focusGained(e);
			}
		});
		Adresse2.setColumns(10);
		Adresse2.setBounds(181, 124, 260, 26);
		contentPane.add(Adresse2);

		Besitzer2 = new JTextField();
		Besitzer2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_Besitzer2_focusLost(e);
			}
			@Override
			public void focusGained(FocusEvent e) {
				do_Besitzer2_focusGained(e);
			}
		});
		Besitzer2.setColumns(10);
		Besitzer2.setBounds(181, 162, 260, 26);
		contentPane.add(Besitzer2);

		Telefonnummer2 = new JTextField();
		Telefonnummer2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_Telefonnummer2_focusLost(e);
			}
			@Override
			public void focusGained(FocusEvent e) {
				do_Telefonnummer2_focusGained(e);
			}
		});
		Telefonnummer2.setColumns(10);
		Telefonnummer2.setBounds(181, 200, 260, 26);
		contentPane.add(Telefonnummer2);

		Email2 = new JTextField();
		Email2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_Email2_focusLost(e);
			}
			@Override
			public void focusGained(FocusEvent e) {
				do_Email2_focusGained(e);
			}
		});
		Email2.setColumns(10);
		Email2.setBounds(181, 238, 260, 26);
		contentPane.add(Email2);

		Restaurantkategorie2 = new JTextField();
		Restaurantkategorie2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				do_Restaurantkategorie2_focusLost(e);				
			}
			@Override
			public void focusGained(FocusEvent e) {
				do_Restaurantkategorie2_focusGained(e);
			}
		});
		Restaurantkategorie2.setColumns(10);
		Restaurantkategorie2.setBounds(181, 276, 260, 26);
		contentPane.add(Restaurantkategorie2);

		KurzeBeschreibung2 = new JTextField();
		KurzeBeschreibung2.setColumns(10);
		KurzeBeschreibung2.setBounds(197, 317, 345, 64);
		contentPane.add(KurzeBeschreibung2);
		{
			Name = new JLabel("Name : ");
			Name.setBounds(55, 91, 61, 16);
			contentPane.add(Name);
		}
		{
			Adresse = new JLabel("Adresse : ");
			Adresse.setBounds(55, 129, 75, 16);
			contentPane.add(Adresse);
		}
		{
			Besitzer = new JLabel("Besitzer : ");
			Besitzer.setBounds(55, 167, 61, 16);
			contentPane.add(Besitzer);
		}
		{
			Telefonnummer = new JLabel("Telefonnummer : ");
			Telefonnummer.setBounds(55, 205, 114, 16);
			contentPane.add(Telefonnummer);
		}
		{
			Email = new JLabel("E-Mail : ");
			Email.setBounds(55, 243, 61, 16);
			contentPane.add(Email);
		}
		{
			Restaurantkategorie = new JLabel("Restaurantkategorie : ");
			Restaurantkategorie.setBounds(29, 281, 140, 16);
			contentPane.add(Restaurantkategorie);
		}
		{
			KurzeBeschreibung = new JLabel("Kurze Beschreibung : ");
			KurzeBeschreibung.setBounds(29, 326, 156, 16);
			contentPane.add(KurzeBeschreibung);
		}
	}

	protected void do_Speichern_actionPerformed(ActionEvent e) {

	}
	protected void do_Name2_1_focusLost(FocusEvent e) {
		if(Name2_1.getText().equals("")) {
			Name2_1.setBackground(Color.red);
			Name2_1.setText("Bitte ausfüllen!");
		}	
		else {
			this.nameOK=true;
		}
	}
	protected void do_Name2_1_focusGained(FocusEvent e) {
		Name2_1.setText("");
		Name2_1.setBackground(Color.white);
	}
	protected void do_Adresse2_focusLost(FocusEvent e) {
		if(Adresse2.getText().equals("")) {
			Adresse2.setBackground(Color.red);
			Adresse2.setText("Bitte ausfüllen!");
		}	
		else {
			this.nameOK=true;
		}
	}
	protected void do_Adresse2_focusGained(FocusEvent e) {
		Adresse2.setText("");
		Adresse2.setBackground(Color.white);
	}
	protected void do_Besitzer2_focusLost(FocusEvent e) {
		if(Besitzer2.getText().equals("")) {
			Besitzer2.setBackground(Color.red);
			Besitzer2.setText("Bitte ausfüllen!");
		}	
		else {
			this.nameOK=true;
		}
	}
	protected void do_Besitzer2_focusGained(FocusEvent e) {

		Besitzer2.setText("");
		Besitzer2.setBackground(Color.white);
	}
	protected void do_Telefonnummer2_focusLost(FocusEvent e) {
		if(Telefonnummer2.getText().equals("")) {
			Telefonnummer2.setBackground(Color.red);
			Telefonnummer2.setText("Bitte ausfüllen!");
		}	
		else {
			this.nameOK=true;
		}
	}
	protected void do_Telefonnummer2_focusGained(FocusEvent e) {
		Telefonnummer2.setText("");
		Telefonnummer2.setBackground(Color.white);
	}
	protected void do_Email2_focusLost(FocusEvent e) {
		if(Email2.getText().equals("")) {
			Email2.setBackground(Color.red);
			Email2.setText("Bitte ausfüllen!");
		}else if(Email2.getText().contains("")){

		}
		else {
			this.nameOK=true;
		}
	}
	protected void do_Email2_focusGained(FocusEvent e) {
		Email2.setText("");
		Email2.setBackground(Color.white);
	}
	protected void do_Restaurantkategorie2_focusLost(FocusEvent e) {
		if(Restaurantkategorie2.getText().equals("")) {
			Restaurantkategorie2.setBackground(Color.red);
			Restaurantkategorie2.setText("Bitte ausfüllen!");
		}	
		else {
			this.nameOK=true;
		}
	}

	protected void do_Restaurantkategorie2_focusGained(FocusEvent e) {
		Restaurantkategorie2.setText("");
		Restaurantkategorie2.setBackground(Color.white);
	}

	public static boolean isValidEmailAddress(String email) {
		boolean result = true;
		try {
			System.out.println(Inet4Address.getAllByName(email));
			
		} catch (Exception ex) {
			result = false;
		}
		return result;
	}
}

