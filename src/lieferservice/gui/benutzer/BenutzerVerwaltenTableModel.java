/**
 * 
 */
package lieferservice.gui.benutzer;

import java.util.*;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import lieferservice.Benutzer;


/**
 * Diese Klasse dient der Verwaltung der Daten in der Tabelle für den Bildschirm der Benutzerverwaltung
 * @author masomahibrahimi
 *
 */
public class BenutzerVerwaltenTableModel implements TableModel {
	
	/**
	 * Dieser Vector enthält die Benutzerdaten aus der Datenbank
	 */
	Vector<Benutzer> benutzerDaten;
	
	
	/**
	 * Der Konstruktor liest die Daten aus der Datenbank ein
	 */
	public BenutzerVerwaltenTableModel() {
		benutzerDaten = Benutzer.alleBenutzer();
	}

	
	/**
	 * Liefert die Anzahl der Zeilen
	 */
	@Override
	public int getRowCount() {
		return benutzerDaten.size();
	}

	
	/**
	 * In der Tabelle werden fünf Spalten dargestellt:
	 * - Name
	 * - programmAdministrator
	 * - restaurantAdministrator
	 * - bestellungsBearbeiter
	 * - abrechner
	 */
	@Override
	public int getColumnCount() {
		return 5;
	}

	
	/**
	 * Liefert Namen der Spalten
	 */
	@Override
	public String getColumnName(int columnIndex) {
		switch (columnIndex) {
		case 0: return "Name";
		case 1: return "Programmadministrator";
		case 2: return "Restaurantadministrator";
		case 3: return "Bestellungsbearbeiter";
		case 4: return "Abrechner";
		default:
			throw new IllegalArgumentException("Was ist denn das für ein columnIndex??? :" + columnIndex);
		}
	}

	
	/**
	 * Liefert den Datentyp der Spalten
	 */
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0: return String.class;
		case 1:
		case 2:
		case 3:
		case 4:
			return Boolean.class;
		default:
			throw new IllegalArgumentException("Was ist denn das für ein columnIndex??? :" + columnIndex);
		}
	}

	
	/**
	 * Der Benutzername ist nicht editierbar, wohl aber die Attribute für die Rechte
	 */
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return columnIndex != 0;
	}

	
	/**
	 * Liefert den Wert für die gegebene Zelle
	 * @param rowIndex Zeilennummer
	 * @param columnIndex Spaltennummer
	 * @return Wert der angegebenen Zelle
	 */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return benutzerDaten.elementAt(rowIndex).getName();
		case 1:
			return Boolean.valueOf(benutzerDaten.elementAt(rowIndex).isProgrammAdministrator());
		case 2:
			return Boolean.valueOf(benutzerDaten.elementAt(rowIndex).isRestaurantAdministrator());
		case 3:
			return Boolean.valueOf(benutzerDaten.elementAt(rowIndex).isBestellungsBearbeiter());
		case 4:
			return Boolean.valueOf(benutzerDaten.elementAt(rowIndex).isAbrechner());
		default:
			throw new IllegalArgumentException("Was ist denn das für ein columnIndex??? :" + columnIndex);
		}
	}

	
	/**
	 * Wird zur Zeit nicht benötigt
	 */
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Benutzer b = benutzerDaten.elementAt(rowIndex);
		Boolean value;
		
		switch (columnIndex) {
		case 0:
			break;
		case 1:
			value = (Boolean) aValue;
			b.setProgrammAdministrator(value);
			break;
		case 2:
			value = (Boolean) aValue;
			b.setRestaurantAdministrator(value);
			break;
		case 3:
			value = (Boolean) aValue;
			b.setBestellungsBearbeiter(value);
			break;
		case 4:
			value = (Boolean) aValue;
			b.setAbrechner(value);
			break;
		default:
			throw new IllegalArgumentException("Was ist denn das für ein columnIndex??? :" + columnIndex);
		}

	}

	
	/**
	 * Wird zur Zeit nicht benötigt
	 */
	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub

	}

	
	/**
	 * Wird zur Zeit nicht benötigt
	 */
	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub

	}
	
	
	/**
	 * Liefert den Benutzer in der angegebenen Zeile
	 */
	public Benutzer getBenutzerInZeile(int zeile) {
		return benutzerDaten.elementAt(zeile);
	}

}
