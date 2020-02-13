package TopTier;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.text.Utilities;

public class MainGui extends JFrame {

	private JPanel contentPane;
	private Startseite startseite = new Startseite(this);
	private Profil profil = new Profil(this);
	private Impressum impressum = new Impressum(this);
	private HashMap<Views, Panelvorlage> panels = new HashMap<>();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGui frame = new MainGui();
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
	public MainGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setContentPane(startseite);
		
		panels.put(Views.startseite, this.startseite);
		panels.put(Views.profil, this.profil);
		panels.put(Views.impressum, this.impressum);
	}
	

	public void switchTo(Views v) {
		setContentPane(this.panels.get(v));
		
		SwingUtilities.updateComponentTreeUI(this);
	}
}
