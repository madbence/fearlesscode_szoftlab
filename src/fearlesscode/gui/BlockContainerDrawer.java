package fearlesscode.gui;

import fearlesscode.model.container.*;
import java.awt.*;
import java.awt.geom.*;

public class BlockContainerDrawer implements Drawer
{
	private BlockContainer container;
	public BlockContainerDrawer(BlockContainer c)
	{
		container=c;
	}
	public void draw(Graphics2D g)
	{
		AffineTransform t=g.getTransform();
		g.translate((container.getPosition().getX()-1)*200, (container.getPosition().getY()-1)*150);
		BlockDrawer drawer=container.getBlock().getBlockDrawer();
		if(container.getPlayField().isBlockMode())
		{
			g.translate(20, 15);
			g.scale(0.8, 0.8);
		}
		if(drawer != null)
		{
			drawer.draw(g);
		}
		g.setTransform(t);
	}
}