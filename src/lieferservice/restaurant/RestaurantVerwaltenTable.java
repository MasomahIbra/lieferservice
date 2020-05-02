package lieferservice.restaurant;

import javax.swing.JTable;

public class RestaurantVerwaltenTable extends JTable{
	
	public RestaurantVerwaltenTable () {
		setModel(new RestaurantVerwaltenTableModel());
	}
	

}
