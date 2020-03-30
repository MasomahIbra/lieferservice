/**
 * 
 */
package lieferservice.gui.benutzer;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import lieferservice.gui.GuiSettings;

/**
 * Diese Klasse stellt die Tablle im Dialog zur Benutzerverwaltung dar.
 * @author masomahibrahimi
 *
 */
public class BenutzerVerwaltenTable extends JTable {

	/**
	 * Konstruktor
	 */
	public BenutzerVerwaltenTable(BenutzerVerwaltenTableModel tableModel) {
		super(tableModel, null);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		// Den Zeichensatz größer machen
		{
			this.setFont(GuiSettings.getTextFont(this.getFont()));
			this.getTableHeader().setFont(GuiSettings.getBoldTextFont(this.getTableHeader().getFont()));
			
			// Die Zeilengröße muss angepasst werden. Ansonsten ragt die Schrift durch den vergrößerten Zeichensatz
			// aus den Zellen heraus. Dafür lassen wir durch die Tabelle die Höhe des Fonts berechnen und
			// schlagen noch ein paar Pixel drauf
			int rowHeight = getFontMetrics(this.getFont()).getHeight() + 4;
			this.setRowHeight(rowHeight);
		}
		
		// Hintergrundfarbe für die Tabellenüberschrift setzen
		this.getTableHeader().setBackground(GuiSettings.DEFAULT_BACKGROUND_COLOR);
			
		// Aua, das tut weh. Aber ich habe keinen Bock, das jetzt dynamisch zu berechnen.
		// Das geht aber.
		// Die minimale Breite der Spalte mit den Namen wird auf 200 Punkte gesetzt. Die anderen Spalten werden
		// fest auf 200 Punkte gesetzt.
		TableColumn tc = this.getColumnModel().getColumn(0);
		tc.setMinWidth(200);
		
		for (int zaehler = 1; zaehler < this.getColumnModel().getColumnCount(); zaehler++) {
			tc = this.getColumnModel().getColumn(zaehler);
			tc.setMinWidth(200);
			tc.setMaxWidth(200);
		}
		
		// Für die gesamte Tabelle wird die minimale Breite auf 800 Punkte gesetzt.
		this.setMinimumSize(new Dimension(800, 200));
	}

	
	/**
	 * Überladene Methode, um die Zeilen farbig zu unterscheiden
	 */
	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		
		Component comp = super.prepareRenderer(renderer, row, column);
        if (row == this.getSelectedRow()) {
        	comp.setBackground(Color.BLUE);
        }
        else if (row % 2 == 0) {
        	comp.setBackground(GuiSettings.DEFAULT_HIGHLIGHT_COLOR);
        }
        else {
        	comp.setBackground(Color.WHITE);
        }
		return comp;
	}
	

	/**
	 * Überschreiben der Standard-doLayout Methode
	 */
	@Override
	public void doLayout() {
		super.doLayout();
		for (int zaehler = 0; zaehler < this.getColumnCount(); zaehler++) {
			TableColumn column = getColumnModel().getColumn(zaehler);
			column.setResizable(false);
		}
	}
	
	
}
