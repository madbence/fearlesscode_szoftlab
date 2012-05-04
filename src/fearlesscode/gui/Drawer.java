package fearlesscode.gui;

import java.awt.*;
import java.awt.image.BufferedImage;


/**
 * Interfész a rajzolóknak.
 */
public interface Drawer
{
	/**
	 * Minden rajzolónak kötelező definiálnia egy ilyen metódust.
	 * @param g A rajzolónak erre kell rajzolnia.
	 */
	public void draw(Graphics2D g);
}