package fearlesscode.gui;

import fearlesscode.model.container.*;
import java.awt.*;
import java.awt.geom.*;

/**
 * Egy blokk konténerének kirajzolásáért felelős.
 */
public class BlockContainerDrawer implements Drawer
{
	/**
	 * A kirajzolandó blokk konténer objektum.
	 */
	private BlockContainer container;

	/**
	 * Létrehoz egy rajzolót a megadott konténerrel.
	 */
	public BlockContainerDrawer(BlockContainer c)
	{
		container=c;
	}

	/**
	 * A kapott grafikus felületet eltranszformálja a megadott pozícióba, a játékmód állapotától függően nagyít rajta, 
	 * majd kirajzolja a konténerben találhatóü blokkot (meghívja a blokk kirajzolójának draw metódusát).
	 * @param g A grafikus felület, amire rajzolunk.
	 */
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