package fearlesscode.gui;

import fearlesscode.model.block.*;
import fearlesscode.model.container.*;
import java.awt.*;

/**
 * Egy FilledBlock objektumot kirajzol.
 */
public class FilledBlockDrawer extends BlockDrawer
{
	/**
	 * Létrehoz egy új rajzolót a megadott FilledBlocknak.
	 * @param subject A kirajzolandó FilledBlock.
	 */
	public FilledBlockDrawer(FilledBlock subject)
	{
		super(subject);
	}

	/**
	 * Végigiterál az entitásokon, és a játékosokon, és mindnek meghívja a draw metódusát.
	 * @param g A grafikus felület, amire rajzolunk.
	 */
	public void draw(Graphics2D g)
	{
		g.setPaint(Color.black);
		g.drawRect(0,0,(int)Block.WIDTH,(int)Block.HEIGHT);
		g.clipRect(0,0,(int)Block.WIDTH,(int)Block.HEIGHT);
		for(EntityContainer entity:block.getEntities())
		{
			EntityContainerDrawer drawer=new EntityContainerDrawer(entity);
			drawer.draw(g);
		}
		for(PlayerContainer player:block.getPlayers())
		{
			PlayerContainerDrawer drawer=new PlayerContainerDrawer(player);
			drawer.draw(g);
		}
		g.setClip(null);
	}
}