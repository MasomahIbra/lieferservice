/**
 * (c) Masomah Ibrahimi 2020
 */
package lieferservice.gui;

import java.awt.Color;
import java.awt.Font;

/**
 * Diese Klasse definiert Konstanten für die GUI
 * @author masomahibrahimi
 *
 */
public class GuiSettings {
	
	/*
	 * Farbdefinitionen
	 */
	public static final Color PINK = new Color(0xffe0e0);
	public static final Color DARK_PINK = new Color(0xffa0a0);
	public static final Color LIGHTBLUE = new Color(0xc0d0ff);
	
	
	public static final Color DEFAULT_HIGHLIGHT_COLOR = PINK;
	public static final Color DEFAULT_BACKGROUND_COLOR = DARK_PINK;
	
	/*
	 * Faktor, um den die Zeichensätze vergrößert werden
	 */
	private static final double HEADING_SIZE_FACTOR = 2;
	private static final double TEXT_SIZE_FACTOR = 1.3;
	
	
	/**
	 * Liefert einen Zeichensatz, der um den Faktor HEADING_SIZE_FACTOR vergrößert wurde.
	 * @param sourceFont Zeichensatz, der verändert werden soll
	 * @return Vergrößerter Zeichensatz
	 */
	public static Font getHeadingFont(Font sourceFont) {
		return new Font(sourceFont.getName(),Font.PLAIN ,(int)(sourceFont.getSize2D()* HEADING_SIZE_FACTOR));
	}

	
	/**
	 * Liefert einen Zeichensatz, der um den Faktor TEXT_SIZE_FACTOR vergrößert wurde.
	 * @param sourceFont Zeichensatz, der verändert werden soll
	 * @return Vergrößerter Zeichensatz
	 */
	public static Font getTextFont(Font sourceFont) {
		return new Font(sourceFont.getName(),Font.PLAIN ,(int)(sourceFont.getSize2D()* TEXT_SIZE_FACTOR));
	}

	
	/**
	 * Liefert einen Zeichensatz, der um den Faktor TEXT_SIZE_FACTOR vergrößert wurde mit fetter Schrift.
	 * @param sourceFont Zeichensatz, der verändert werden soll
	 * @return Vergrößerter Zeichensatz
	 */
	public static Font getBoldTextFont(Font sourceFont) {
		return new Font(sourceFont.getName(),Font.BOLD ,(int)(sourceFont.getSize2D()* TEXT_SIZE_FACTOR));
	}
}
