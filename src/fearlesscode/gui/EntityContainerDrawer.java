package fearlesscode.gui;

import fearlesscode.model.container.*;
import java.awt.*;
import java.awt.geom.*;

/**
 * Egy entitás konténerét rajzolja ki.
 */
public class EntityContainerDrawer implements Drawer
{
	/**
	 * A kirajzolandó konténer.
	 */
	private EntityContainer container;

	/**
	 * Létrehoz egy rajzolót a megadott konténerhez.
	 * @param c A kirajzolandó konténer.
	 */
	public EntityContainerDrawer(EntityContainer c)
	{
		container=c;
	}

	/**
	 * Eltranszformálja a grafikus felületet az entitás pozíciójába, majd meghívja az entitás rajzolójának draw metódusát.
	 * @param g A grafikus felület, amire rajzolunk.
	 */
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