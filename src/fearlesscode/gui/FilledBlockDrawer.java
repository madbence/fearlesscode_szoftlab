package fearlesscode.gui;

import fearlesscode.model.block.*;
import fearlesscode.model.container.*;
import java.awt.*;

public class FilledBlockDrawer extends BlockDrawer
{
	public FilledBlockDrawer(FilledBlock subject)
	{
		super(subject);
	}
	public void draw(Graphics2D g)
	{
		g.setPaint(Color.black);
		g.drawRect(0,0,200,150);
		g.clipRect(0,0,200,150);
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