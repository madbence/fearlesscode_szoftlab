package fearlesscode.gui;

import java.awt.*;
import fearlesscode.menu.Menu;
import fearlesscode.menu.MenuItem;

public class MenuItemDrawer implements Drawer
{
	private MenuItem item;
	public MenuItemDrawer(MenuItem subject)
	{
		item=subject;
	}
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