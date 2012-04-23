package fearlesscode.gui;

import java.awt.*;
import java.awt.geom.*;
import fearlesscode.menu.Menu;
import fearlesscode.menu.MenuItem;

/**
 * Kirajzol egy menüt.
 */
public class MenuDrawer implements Drawer
{
	/**
	 * A kirajzolandó menü.
	 */
	private Menu menu;

	/**
	 * Létrehoz egy rajzolót a megadott menühöz.
	 */
	public MenuDrawer(Menu subject)
	{
		menu=subject;
	}

	/**
	 * Végigiterál a menüpontokon, és azok rajzolóján meghívja a draw metódust.
	 * Közben a grafikus felületet úgy transzformálja, hogy a menüpontok egymás alá kerüljenek.
	 * @param g A grafikus felület, amire rajzolunk.
	 */
	public void draw(Graphics2D g)
	{
		AffineTransform t=g.getTransform();
		g.translate(100, 60);
		for(MenuItem item:menu.getItems())
		{
			MenuItemDrawer drawer=new MenuItemDrawer(item);
			drawer.draw(g);
			g.translate(0, 20);
		}
		g.setTransform(t);
	}
}