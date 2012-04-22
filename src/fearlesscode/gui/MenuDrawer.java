package fearlesscode.gui;

import java.awt.*;

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
		for(MenuItem item:menu.getItems())
		{
			MenuItemDrawer drawer=new MenuItemDrawer(item);
			drawer.draw(g);
			g.translate(0, 20);
		}
		g.setTransform(t);
	}
}