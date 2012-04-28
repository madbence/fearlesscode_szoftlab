package fearlesscode.gui;

import fearlesscode.model.container.*;
import fearlesscode.model.block.*;
import java.awt.*;
import java.awt.geom.*;

/**
 * Egy blokk konténerének kirajzolásáért felelős.
 */
public class BlockContainerDrawer implements Drawer
{
	public static final int WIDTH=300;
	public static final int HEIGHT=200;
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
		double scaleX=(double)WIDTH/Block.WIDTH;
		double scaleY=(double)HEIGHT/Block.HEIGHT;
		g.translate(
			(container.getPosition().getX()-1)*WIDTH+20,
			(container.getPosition().getY()-1)*HEIGHT+40);
		BlockDrawer drawer=container.getBlock().getBlockDrawer();
		g.scale(0.95*scaleX, 0.95*scaleY);
		if(container.getPlayField().isBlockMode())
		{
			g.translate(20, 15);
			g.scale(0.9, 0.9);
		}
		if(drawer != null)
		{
			drawer.draw(g);
		}
		g.setTransform(t);
	}
}