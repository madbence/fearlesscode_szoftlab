package fearlesscode.gui;

import fearlesscode.model.player.*;
import java.awt.*;

public class PlayerDrawer implements Drawer
{
	private Player player;
	public PlayerDrawer(Player subject)
	{
		player=subject;
	}
	public void draw(Graphics2D g)
	{
		g.setPaint(Color.blue);
		g.fillRect(0,0,10,20);
	}
}