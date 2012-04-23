package fearlesscode.gui;

import fearlesscode.model.container.*;
import java.awt.*;
import java.awt.geom.*;

/**
 * Egy játékos konténerét rajzolja ki.
 */
public class PlayerContainerDrawer implements Drawer
{
	/**
	 * A kirajzolandó konténer.
	 */
	private PlayerContainer container;

	/**
	 * Létrehoz egy rajzolót a megadott konténerhez.
	 * @param subject A kirajzolandó konténer.
	 */
	public PlayerContainerDrawer(PlayerContainer subject)
	{
		container=subject;
	}

	/**
	 * Eltranszformálja a grafikus felületet a játékos pozíciójára, majd meghívja a játékos 
	 * kirajzolójának draw() metódusát.
	 * @param g A grafikus felület, amire rajzolunk.
	 */
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