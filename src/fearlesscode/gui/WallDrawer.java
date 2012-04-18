package fearlesscode.gui;

import fearlesscode.*;
import java.awt.*;

public class WallDrawer extends EntityDrawer
{
	public WallDrawer(Wall subject)
	{
		super(subject);
	}
	public void draw(Graphics2D g)
	{
		Wall wall=(Wall)entity;
		g.setPaint(Color.black);
		g.fillRect(0,0,(int)wall.getWidth(),(int)wall.getHeight());
	}
}