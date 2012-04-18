package fearlesscode.gui;

import fearlesscode.*;
import java.awt.*;
import java.awt.geom.*;

public class PlayerContainerDrawer
{
	private PlayerContainer container;
	public PlayerContainerDrawer(PlayerContainer subject)
	{
		container=subject;
	}
	public void draw(Graphics2D g)
	{
		AffineTransform t=g.getTransform();
		g.translate(container.getPosition().getX(), container.getPosition().getY());
		PlayerDrawer drawer=container.getPlayer().getPlayerDrawer();
		if(drawer != null)
		{
			drawer.draw(g);
		}
		g.setTransform(t);
	}
}