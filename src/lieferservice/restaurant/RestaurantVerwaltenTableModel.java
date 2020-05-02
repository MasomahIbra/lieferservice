package lieferservice.restaurant;

import java.util.Vector;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class RestaurantVerwaltenTableModel implements TableModel {
Vector<Restaurant>restaurantDaten;
	
	public RestaurantVerwaltenTableModel() {
		restaurantDaten = Restaurant.alleRestaurants();
	}
	@Override
	public int getRowCount() {
		
		return restaurantDaten.size();
	}

	@Override
	public int getColumnCount() {
	
		return 5;
	}

	@Override
	public String getColumnName(int columnIndex) {
		switch (columnIndex) {
		case 0:  return "Name";
		case 1: return "Restaurantkategorie";	
		case 2: return "Adresse";
		case 3: return "Telefon";
		case 4: return "Email";
			
		
		default:
			throw new IllegalArgumentException("Unexpected value: " + columnIndex);
		}
	
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		
		return String.class;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		
		return true;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Restaurant r = restaurantDaten.elementAt(rowIndex);
		if (columnIndex == 0) 
			return r.getName();
		if (columnIndex == 1)
			return r.getRestaurantkategorie();
		if (columnIndex == 2)
			return r.getAdresse();
		if (columnIndex == 3)
			return r.getTelefon();
		if (columnIndex == 4)
			return r.getEmail();
		throw new IllegalArgumentException("illegal columnIndex: " + columnIndex);
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Restaurant r = restaurantDaten.elementAt(rowIndex);
		if (columnIndex == 0)
			r.setName((String) aValue);
		if (columnIndex == 1)
			 r.setRestaurantkategorie((String) aValue);
		if (columnIndex == 2)
			r.setAdresse((String) aValue);
		if (columnIndex == 3)
			r.setTelefon((String) aValue);
		if (columnIndex == 4)
			r.setAdresse((String) aValue);

	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		

	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub

	}
	/**
	 * Liefer das Restaurant in der angegebenen Zeile
	 * @param Zeile
	 * @return
	 */

	public Restaurant getRestaurantInZeilen(int Zeilen) {
		return restaurantDaten.elementAt(Zeilen);
	}
}
