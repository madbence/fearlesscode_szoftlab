package fearlesscode.gui;

import java.awt.*;
import java.awt.geom.*;
import fearlesscode.menu.Menu;
import fearlesscode.menu.MenuItem;

public class MenuDrawer implements Drawer
{
	private Menu menu;
	public MenuDrawer(Menu subject)
	{
		menu=subject;
	}
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