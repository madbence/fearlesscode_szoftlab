package fearlesscode.gui;

import fearlesscode.model.container.*;
import java.awt.*;
import java.awt.geom.*;

public class EntityContainerDrawer implements Drawer
{
	private EntityContainer container;
	public EntityContainerDrawer(EntityContainer c)
	{
		container=c;
	}
	public void draw(Graphics2D g)
	{
		AffineTransform t=g.getTransform();
		g.translate(container.getPosition().getX(), container.getPosition().getY());
		EntityDrawer drawer=container.getEntity().getEntityDrawer();
		if(drawer != null)
		{
			drawer.draw(g);
		}
		g.setTransform(t);
	}
}