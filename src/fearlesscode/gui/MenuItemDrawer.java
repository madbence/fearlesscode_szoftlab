package fearlesscode.gui;

import java.awt.*;
import fearlesscode.menu.Menu;
import fearlesscode.menu.MenuItem;

/**
 * Egy menüpontot rajzol ki.
 */
public class MenuItemDrawer implements Drawer
{
	/**
	 * A kirajzolandó menüpont.
	 */
	private MenuItem item;

	/**
	 * Létrehoz egy rajzolót a megadott menüponthoz.
	 * @param subject A kirajzolandó menüpont.
	 */
	public MenuItemDrawer(MenuItem subject)
	{
		item=subject;
	}

	/**
	 * A menüpont állapotától függően (aktív/inaktív) kirajzolja a menüpontot.
	 * Natív AWT metódusokat használ.
	 * @param g A grafikus felület, amire rajzolunk.
	 */
	public void draw(Graphics2D g)
	{
		if(item.isActive())
		{
			g.setPaint(Color.red);
		}
		else
		{
			g.setPaint(Color.black);
		}
		g.drawString(item.getTitle(),0,0);
		//g.fillRect(30, 30, 30, 30);
	}
}