package fearlesscode.gui;

import java.awt.*;

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
			g.setPaint(Paint.red);
		}
		else
		{
			g.setPaint(Paint.black);
		}
		g.drawString(item.getTitle(),0,0);
	}
}